package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro2;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

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
    public Libro seleccionarPorTitulo(String titulo) {
        TypedQuery<Libro> typedQuery=this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :varibleTitulo", Libro.class);
        typedQuery.setParameter("varibleTitulo",titulo);
        return typedQuery.getSingleResult();
    }

    @Override
    public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion) {
        TypedQuery<Libro> query = this.entityManager.createNamedQuery("Libro.queryBuscarPorFechaNamed",Libro.class);

        query.setParameter("fecha", fechaPublicacion);
        return query.getResultList();
    }


    @Override
    public Libro seleccionarPorTituloNamed(String titulo) {
        TypedQuery<Libro> typedQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo", Libro.class);
        typedQuery.setParameter("titulo",titulo);

        return typedQuery.getSingleResult();
    }

    @Override
    public Libro seleccionar(Integer id) {
        return this.entityManager.find(Libro.class, id);
    }

    @Override
    public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
        Query query =
                this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >= :fecha");
        query.setParameter("fecha", fechaPublicacion);
        return (List<Libro>) query.getResultList();
    }

    @Override
    public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion) {
        TypedQuery<Libro> typedQuery =
                this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >= :fecha", Libro.class);
        typedQuery.setParameter("fecha", fechaPublicacion);
        return typedQuery.getResultList();
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
