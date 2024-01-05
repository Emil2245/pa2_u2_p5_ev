package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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
