package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
