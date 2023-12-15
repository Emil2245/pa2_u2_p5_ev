package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    @Column (name = "mat_id")
    @GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "generatorMat")
    @SequenceGenerator(name = "generatorMat",sequenceName = "seq_matricula",allocationSize = 1)
    private Integer id;
    @Column (name = "mat_nombre")
    private String nombre;
    @Column (name = "mat_creditos")
    private Integer creditos;

    //getters and setters
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

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
}
