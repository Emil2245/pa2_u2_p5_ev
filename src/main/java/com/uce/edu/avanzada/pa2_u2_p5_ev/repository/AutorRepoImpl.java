package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Autor;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Autor2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AutorRepoImpl implements IAutorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Autor select(Integer id) {
        return this.entityManager.find(Autor.class, id);
    }

    @Override
    public void insert(Autor autor) {
        this.entityManager.persist(autor);
    }

    @Override
    public void insert(Autor2 autor2) {
        this.entityManager.persist(autor2);

    }

    @Override
    public void delete(Integer id) {
        Autor autor = this.select(id);
        this.entityManager.remove(autor);
    }

    @Override
    public void update(Autor autor) {
        this.entityManager.merge(autor);
    }

    @Override
    public void update(Autor2 autor2) {
        this.entityManager.merge(autor2);
    }
}
