package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository
@Transactional
public class LibroRepoImpl implements ILibroRepository{
    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public Libro seleccionar(Integer id) {
//        return null;
//    }

    @Override
    public void insertar(Libro libro) {
        this.entityManager.persist(libro);
    }
//
//    @Override
//    public void actualizar(Libro libro) {
//
//    }
//
//    @Override
//    public void eliminar(Integer id) {
//
//    }
//

}
