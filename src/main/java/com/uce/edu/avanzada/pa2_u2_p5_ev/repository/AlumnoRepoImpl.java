package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Alumno;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AlumnoRepoImpl implements IAlumnoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Alumno seleccionar(Integer id) {
        return this.entityManager.find(Alumno.class, id);

    }

    @Override
    public void insertar(Alumno alumno) {
        this.entityManager.persist(alumno);
    }

    @Override
    public void actualizar(Alumno alumno) {
        this.entityManager.merge(alumno);

    }

    @Override
    public void eliminar(Integer id) {
        Alumno alumno = this.seleccionar(id);
        this.entityManager.remove(
                alumno
        );
    }
}
