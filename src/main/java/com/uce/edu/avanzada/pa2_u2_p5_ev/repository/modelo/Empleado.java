package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table (name = "empleado")
public class Empleado {
    @Id
    @SequenceGenerator(name = "generator_emplId", allocationSize = 1,sequenceName = "seq_empl_id")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generator_emplId")
    @Column (name = "empl_id")
    private  Integer id;
    @Column (name = "empl_salario")
    private BigDecimal salario;
    @Column (name = "empl_fecha_ingreso")
    private LocalDateTime fechaIngreso;
    @OneToOne
    @JoinColumn (name = "empl_id_cuidadano")
    private Ciudadano ciudadano;

    //Getters and setters

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
