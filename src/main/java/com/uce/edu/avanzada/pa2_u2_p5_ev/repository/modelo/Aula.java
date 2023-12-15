package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

@Entity
@Table (name = "aula")
public class Aula {
    @Id
    @Column(name = "aula_id")
    @GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "genAula")
    @SequenceGenerator(name = "genAula", sequenceName = "seq_aula",allocationSize = 1)
    private Integer id;
    @Column(name = "aula_nombre")
    private String nombre;
    @Column(name = "aula_capacidad")
    private Integer capacidad;

}
