package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;

import java.util.Set;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @SequenceGenerator(name = "generator_autor_id", allocationSize = 1, sequenceName = "seq_autor_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_autor_id")
    @Column(name = "auto_id")
    private Integer id;
    @Column(name = "auto_nombre")
    private String nombre;
    @Column(name = "auto_nacionalidad")
    private String nacionalidad;
    @ManyToMany(mappedBy = "autores", cascade = CascadeType.ALL)
    private Set<Libro> libros;

    /////////////////////////
    public Autor() {
    }

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    ////////////////////////////
    //get set & toString


    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", libros=" + libros +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
