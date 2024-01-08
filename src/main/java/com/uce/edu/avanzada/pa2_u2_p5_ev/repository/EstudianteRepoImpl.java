package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Estudiante;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante seleccionar(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        Estudiante estudiante = this.seleccionar(id);
        this.entityManager.remove(estudiante);
    }

}
