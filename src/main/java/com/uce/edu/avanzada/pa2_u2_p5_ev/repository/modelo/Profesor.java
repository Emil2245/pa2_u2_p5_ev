package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "profesor")
public class Profesor {
    @Column (name = "prof_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generadorProf")
    @SequenceGenerator(name = "generadorProf", sequenceName = "seq_profesor", allocationSize = 1)
    private Integer id;
    @Column (name = "prof_nombre")
    private String nombre;
    @Column (name = "prof_cedula")
    private String cedula;
    @Column (name = "prof_sueldo")
    private BigDecimal sueldo;

    //Getters and Setters
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }
}
