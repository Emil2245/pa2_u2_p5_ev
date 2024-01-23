package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Habitacion;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Hotel seleccionar(Integer id) {
        return this.entityManager.find(Hotel.class, id);
    }

    @Override
    public List<Habitacion> selectAllRooms(String nombre) {
        TypedQuery<Habitacion> query =
                this.entityManager.createQuery("SELECT l FROM Habitacion l WHERE l.hotel.nombre = :varibleTitulo", Habitacion.class);
        query.setParameter("varibleTitulo", nombre);
        return query.getResultList();
    }

    @Override
    public List<Habitacion> selectRoomsInBetween(String nombre, Integer min, Integer max) {
        TypedQuery<Habitacion> query =
                this.entityManager.createQuery("SELECT l FROM Habitacion l WHERE l.hotel.nombre = :varible and l.numero between :min and :max", Habitacion.class);
        query.setParameter("varible", nombre);
        query.setParameter("min", min);
        query.setParameter("max", max);
        return query.getResultList();
    }

    @Override
    public Hotel selectHotelByName(String name) {
        TypedQuery<Hotel> query =
                this.entityManager.createQuery("SELECT l FROM Hotel l WHERE l.nombre = :varible", Hotel.class);
        query.setParameter("varible", name);
        return query.getResultList().get(0);
    }

    @Override
    public Hotel selectHotelPorDireccion(String direccion) {
        TypedQuery<Hotel> query =
                this.entityManager.createQuery("SELECT l FROM Hotel l WHERE l.direccion = :direccion", Hotel.class);
        query.setParameter("direccion", direccion);
        return query.getResultList().get(0);
    }

    @Override
    public List<Hotel> selectHotelesPorNumHabitaciones(Integer num) {
        TypedQuery<Hotel> query =
                this.entityManager.createQuery("SELECT l FROM Hotel l WHERE SIZE(l.habitaciones) >= :num", Hotel.class);
        query.setParameter("num", num);
        return query.getResultList();
    }

    @Override
    public List<Hotel> selectHotelConPiscina() {
        Query query =
                this.entityManager.createNativeQuery("SELECT * FROM hotel h where h.hote_tiene_piscina = TRUE", Hotel.class);
        return (List<Hotel>) query.getResultList();
    }

    @Override
    public List<Hotel> selectHotelSinPiscina() {
        Query query =
                this.entityManager.createNativeQuery("SELECT * FROM hotel h where h.hote_tiene_piscina = FALSE", Hotel.class);
        return (List<Hotel>) query.getResultList();
    }

    @Override
    public List<Habitacion> selectHabitacionesConVistaPiscina(String name) {
        Query query =
                this.entityManager.createNativeQuery("SELECT * FROM habitacion h WHERE h.habi_tiene_vista_piscina = TRUE AND h.habi_id_hotel = (SELECT hote_id FROM public.hotel WHERE hote_nombre = :name);", Habitacion.class);
        query.setParameter("name", name);
        return (List<Habitacion>) query.getResultList();
    }

    @Override
    public List<Habitacion> selectHabitacionesSinVistaPiscina(String name) {
        Query query =
                this.entityManager.createNativeQuery("SELECT * FROM habitacion h WHERE h.habi_tiene_vista_piscina = FALSE AND h.habi_id_hotel = (SELECT hote_id FROM public.hotel WHERE hote_nombre = :name);", Habitacion.class);
        query.setParameter("name", name);
        return (List<Habitacion>) query.getResultList();
    }

    @Override
    public Integer countHabitacionesPorHotel(String name) {
        Query query =
                this.entityManager.createNativeQuery("SELECT COUNT(*) FROM habitacion h WHERE h.habi_id_hotel=(select l.hote_id from hotel l where l.hote_nombre= :name) ", Integer.class);
        query.setParameter("name", name);
        return (Integer) query.getSingleResult();
    }

    @Override
    public List<Hotel> selectHotelesPorNombre(String nombre) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotel> criteriaQuery = criteriaBuilder.createQuery(Hotel.class);

        Root<Hotel> root = criteriaQuery.from(Hotel.class);
        Predicate predicate = criteriaBuilder.equal(root.get("nombre"), nombre);

        criteriaQuery.where(predicate);

        TypedQuery<Hotel> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Hotel> selectHotelesConPiscina() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotel> criteriaQuery = criteriaBuilder.createQuery(Hotel.class);

        Root<Hotel> root = criteriaQuery.from(Hotel.class);
        Predicate predicate = criteriaBuilder.isTrue(root.get("tienePiscina"));

        criteriaQuery.where(predicate);

        TypedQuery<Hotel> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Habitacion> selectHabitacionesConVistaPiscina() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Habitacion> criteriaQuery = criteriaBuilder.createQuery(Habitacion.class);

        Root<Habitacion> root = criteriaQuery.from(Habitacion.class);
        Predicate predicate = criteriaBuilder.isTrue(root.get("tieneVistaPiscina"));

        criteriaQuery.where(predicate);

        TypedQuery<Habitacion> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Hotel> selectHotelesConHabitacionesVistaPiscina() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotel> criteriaQuery = criteriaBuilder.createQuery(Hotel.class);

        Root<Hotel> root = criteriaQuery.from(Hotel.class);
        Join<Hotel, Habitacion> habitacionesJoin = root.join("habitaciones");

        Predicate predicate = criteriaBuilder.isTrue(habitacionesJoin.get("tieneVistaPiscina"));

        criteriaQuery.select(root).distinct(true).where(predicate);

        TypedQuery<Hotel> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Habitacion> selectHabitacionesEnHotelesPorDireccion(String direccion) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Habitacion> criteriaQuery = criteriaBuilder.createQuery(Habitacion.class);

            Root<Habitacion> root = criteriaQuery.from(Habitacion.class);
            Join<Habitacion, Hotel> hotelJoin = root.join("hotel");

            Predicate predicate = criteriaBuilder.equal(hotelJoin.get("direccion"), direccion);

            criteriaQuery.select(root).where(predicate);

            TypedQuery<Habitacion> typedQuery = entityManager.createQuery(criteriaQuery);
            return typedQuery.getResultList();
    }

    @Override
    public void insertar(Hotel hotel) {
        this.entityManager.persist(hotel);
    }

    @Override
    public void actualizar(Hotel hotel) {
        this.entityManager.merge(hotel);

    }

    @Override
    public void eliminar(Integer id) {
        Hotel hotel = this.seleccionar(id);
        this.entityManager.remove(
                hotel
        );
    }
}
