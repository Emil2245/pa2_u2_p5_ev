package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "hotel")
public class Hotel {
    @Id
    @SequenceGenerator(name = "generator_hoteId", allocationSize = 1,sequenceName = "seq_hote_id")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generator_hoteId")
    @Column (name = "hote_id")
    private Integer id;
    @Column (name = "hote_nombre")
    private  String nombre;
    @Column (name = "hote_direccion")
    private String direccion;
    @Column(name = "hote_habitaciones")
    @OneToMany (mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Habitacion> habitaciones;

    //get set toString
    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", habitaciones=" + habitaciones +
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}
