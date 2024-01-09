package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro2;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LibroRepoImpl implements ILibroRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Libro seleccionarPorNombre(String nombre) {

        //SELECT * FROM libro l WHERE l.libr_titulo = ?
        //SELECT l FROM Libro l WHERE l.titulo = :varibleTitulo
        Query query =
                this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :varibleTitulo");
        query.setParameter("varibleTitulo", nombre);
        return (Libro) query.getSingleResult();
    }

    @Override
    public Libro seleccionar(Integer id) {
        return (Libro) this.entityManager.find(Libro.class, id);
    }

    @Override
    public void insertar(Libro libro) {
        this.entityManager.persist(libro);
    }

    @Override
    public void actualizar(Libro libro) {
        this.entityManager.merge(libro);
    }

    @Override
    public void insertar(Libro2 libro2) {
        this.entityManager.persist(libro2);

    }

    @Override
    public void actualizar(Libro2 libro2) {
        this.entityManager.merge(libro2);

    }

    @Override
    public void eliminar(Integer id) {
        Libro libro = this.seleccionar(id);
        this.entityManager.remove(libro);
    }


}
