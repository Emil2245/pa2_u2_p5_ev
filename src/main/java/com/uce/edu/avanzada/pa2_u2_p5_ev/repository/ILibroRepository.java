package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro2;

import java.time.LocalDateTime;
import java.util.List;

public interface ILibroRepository {
    Libro seleccionarPorNombre(String nombre);
    Libro seleccionarPorTitulo(String nombre);
    Libro seleccionarPorTituloNamed(String nombre);
    List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion);
    Libro seleccionar(Integer id);
    List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion);
    List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion);
    void insertar(Libro libro);
    void actualizar (Libro libro);
    void insertar(Libro2 libro2);
    void actualizar (Libro2 libro2);
    void eliminar(Integer id);
}
