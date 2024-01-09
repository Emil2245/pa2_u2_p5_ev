package com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "autor2_libro2")
public class AutorLibro {
    @Id
    @SequenceGenerator(name = "generator_autor2_libro2_id", allocationSize = 1, sequenceName = "seq_autor2_libro2_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_autor2_libro2_id")
    @Column(name = "auli_id")
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auli_id_libro")
    private Libro2 libro2;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auli_id_autor")
    private Autor2 autor2;
    @Column(name = "auli_fecha")
    private LocalDateTime fecha;

    ///////////////////////////////////////////////////////////////////////
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Libro2 getLibro2() {
        return libro2;
    }

    public void setLibro2(Libro2 libro2) {
        this.libro2 = libro2;
    }

    public Autor2 getAutor2() {
        return autor2;
    }

    public void setAutor2(Autor2 autor2) {
        this.autor2 = autor2;
    }

    @Override
    public String toString() {
        return "AutorLibro{" +
                "id=" + id +
                ", libro2=" + libro2 +
                ", autor2=" + autor2 +
                '}';
    }
}
