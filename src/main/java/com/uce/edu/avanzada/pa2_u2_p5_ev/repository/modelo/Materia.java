package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

@Entity
@Table (name = "materia")
public class Materia {
    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generatorMateria")
    @SequenceGenerator(name = "generatorMateria",sequenceName = "seq_materia",allocationSize = 1)
    private Integer id;
    @Column (name = "mate_nombre")
    private String nombre;
    @Column (name = "mate_descripcion")
    private String descripcion;
}
