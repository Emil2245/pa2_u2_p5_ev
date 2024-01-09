package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "libro2")
public class Libro2 {

    @Id
    @SequenceGenerator(name = "generator_libro2", allocationSize = 1,sequenceName = "seq_libro2_id")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generator_libro2")
    @Column(name = "libr_id")
    private Integer id;
    @Column(name = "libr_titulo")
    private String titulo;
    @Column(name = "libr_fechaPublicacion")
    private LocalDateTime fechaPublicacion;

    @OneToMany(mappedBy = "libro2",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<AutorLibro> autoresLibros;
    /////////////////////
    public Libro2() {
    }

    public Libro2(String titulo, LocalDateTime fechaPublicacion) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
    }

    ////////////////////\|/|\/|\
    // get set toString


    @Override
    public String toString() {
        return "Libro2{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", autoresLibros=" + autoresLibros +
                '}';
    }

    public List<AutorLibro> getAutoresLibros() {
        return autoresLibros;
    }

    public void setAutoresLibros(List<AutorLibro> autoresLibros) {
        this.autoresLibros = autoresLibros;
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
