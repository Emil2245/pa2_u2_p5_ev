package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CiudadanoRepoImpl implements ICiudadanoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ciudadano seleccionar(Integer id) {
        return this.entityManager.find(Ciudadano.class, id);
    }

    @Override
    public Ciudadano seleccionarPorCedulaCiu(String id) {
        Query query =
                this.entityManager.createNativeQuery("select * from ciudadano c where c.ciud_cedula = :id ", Ciudadano.class);
        query.setParameter("id", id);
        return (Ciudadano) query.getSingleResult();
    }

    @Override
    public Ciudadano seleccionarPorApellido(String apellido) {
        //0. Creamos una instancia de Criteria Builder a partir del EntityM
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        //1. Determinar el tipo de retorno de la consulta
        CriteriaQuery<Ciudadano> criteriaQuery= criteriaBuilder.createQuery(Ciudadano.class);
        //2. Construir el SQL
        // 2.1 Determinar el FROM con Root
        //SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato;
        Root<Ciudadano> fromObjeto = criteriaQuery.from(Ciudadano.class);
        // 2.2 Construir las condiciones WHERE del SQL
        //Se utiliza los Predicate para como parametro de WHERE
        Predicate condicion = criteriaBuilder.equal(fromObjeto.get("apellido"), apellido);
        criteriaQuery.select(fromObjeto).where(condicion);
        TypedQuery<Ciudadano> typedQuery = this.entityManager.createQuery(criteriaQuery);

        return typedQuery.getSingleResult();
    }

    @Override
    public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Ciudadano> criteriaQuery = criteriaBuilder.createQuery(Ciudadano.class);

        Root<Ciudadano> fromObjeto = criteriaQuery.from(Ciudadano.class);
        Predicate condicion;
        if (cedula.startsWith("17")) {
            condicion = criteriaBuilder.equal(fromObjeto.get("nombre"), nombre);
        } else if (cedula.startsWith("05")) {
            condicion= criteriaBuilder.equal(fromObjeto.get("apellido"), apellido);
        } else {
            condicion= criteriaBuilder.equal(fromObjeto.get("cedula"), cedula);
        }
        criteriaQuery.select(fromObjeto).where(condicion);
        TypedQuery<Ciudadano> typedQuery = this.entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList().get(0);
    }

    @Override
    public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Ciudadano> criteriaQuery = criteriaBuilder.createQuery(Ciudadano.class);

        Root<Ciudadano> fromObjeto = criteriaQuery.from(Ciudadano.class);
        Predicate condicion;
        Predicate condicionNombre = criteriaBuilder.equal(fromObjeto.get("nombre"), nombre);
        Predicate condicionApellido = criteriaBuilder.equal(fromObjeto.get("apellido"), apellido);
        if (cedula.startsWith("17")) {
            //c.nombre = :nombre or c.apellido = :apellido...
            condicion = criteriaBuilder.or(condicionNombre,condicionApellido);
        } else if (cedula.startsWith("05")) {
            //c.nombre = :nombre and c.apellido = :apellido...
            condicion = criteriaBuilder.and(condicionNombre,condicionApellido);
        } else {
            condicion= criteriaBuilder.equal(fromObjeto.get("cedula"), cedula);
        }
        criteriaQuery.select(fromObjeto).where(condicion);
        TypedQuery<Ciudadano> typedQuery = this.entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList().get(0);
    }

    @Override
    public Empleado seleccionarEmpleadoPorCedula(String cedula) {
        TypedQuery<Empleado> query = this.entityManager
                .createQuery("select e from Empleado e where e.ciudadano.cedula = :cedula ",Empleado.class);
        query.setParameter("cedula", cedula);

        return query.getSingleResult();
    }

    @Override
    public void insertar(Ciudadano ciudadano) {
        this.entityManager.persist(ciudadano);
    }

    @Override
    public void actualizar(Ciudadano ciudadano) {
        this.entityManager.merge(ciudadano);
    }

    @Override
    public void eliminar(Integer id) {
        Ciudadano ciudadano = this.seleccionar(id);
        this.entityManager.remove(ciudadano);
    }

}
