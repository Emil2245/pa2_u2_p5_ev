package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

@Entity
@Table (name = "carro")
public class Carro {
    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generatorCarro")
    @SequenceGenerator(name = "generatorCarro",sequenceName = "seq_carro",allocationSize = 1)
    private Integer id;
    @Column (name = "carr_modelo")
    private String modelo;
    @Column (name = "carr_placa")
    private String placa;
    @Column (name = "carr_cilindraje")
    private Double cilindraje;

}
