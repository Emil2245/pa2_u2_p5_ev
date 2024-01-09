package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "autor2")
@Entity
public class Autor2 {
    @Id
    @SequenceGenerator(name = "generator_autor2_id", allocationSize = 1, sequenceName = "seq_autor2_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_autor2_id")
    @Column(name = "auto_id")
    private Integer id;
    @Column(name = "auto_nombre")
    private String nombre;
    @Column(name = "auto_nacionalidad")
    private String nacionalidad;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "autor2")
    private List<AutorLibro> autoresLibros;

    /////////////////////////
    public Autor2() {
    }

    public Autor2(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    ////////////////////////////
    //get set & toString


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
