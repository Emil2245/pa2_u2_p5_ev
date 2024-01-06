package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @SequenceGenerator(name = "generator_libro", allocationSize = 1,sequenceName = "seq_libro_id")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generator_libro")
    @Column(name = "libr_id")
    private Integer id;
    @Column(name = "libr_titulo")
    private String titulo;
    @Column(name = "libr_fechaPublicacion")
    private LocalDateTime fechaPublicacion;
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "autor_libro",
            joinColumns = @JoinColumn(name = "autor_libro_id_libro"),
            inverseJoinColumns = @JoinColumn(name = "autor_libro_id_autor"))
    private Set<Autor> autores;
    /////////////////////


    public Libro() {
    }

    public Libro(String titulo, LocalDateTime fechaPublicacion) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
    }

    ////////////////////\|/|\/|\
    // get set toString
    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", autores=" + autores +
                '}';
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
