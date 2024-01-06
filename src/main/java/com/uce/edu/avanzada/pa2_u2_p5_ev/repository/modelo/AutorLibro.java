package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor2_libro2")
public class AutorLibro {
    @Id
    @Column(name = "autor2_libro2_id")
    private Integer id;
    private  Libro2 libro2;
    private  Autor2 autor2;
}
