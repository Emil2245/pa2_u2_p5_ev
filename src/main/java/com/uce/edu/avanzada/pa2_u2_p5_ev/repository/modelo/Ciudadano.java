package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

@Entity
@Table (name = "ciudadano")
public class Ciudadano {
    @Column(name = "ciud_id")
    @SequenceGenerator(name = "generator_ciudId", allocationSize = 1,sequenceName = "seq_ciud_id")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generator_ciudId")
    @Id
    private Integer id;
    @Column(name = "ciud_nombre")
    private String nombre;
    @Column(name = "ciud_apellido")
    private String apellido;
    @OneToOne(mappedBy = "ciudadano",cascade = CascadeType.ALL)//nombre del atributo de la otra tabla
    private Empleado empleado;



    //toString, settters y getters

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Ciudadano{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
