package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro2;

import java.time.LocalDateTime;
import java.util.List;

public interface ILibroService {
    Libro buscarPorNombre(String nombre);
    Libro buscarPorTitulo(String nombre);
    Libro buscar(Integer id);
    List<Libro> buscarPorFechaPublicacion(LocalDateTime fechaPublicacion);
    List<Libro> buscarPorFechaPublicacionNamed(LocalDateTime fechaPublicacion);
    List<Libro> buscarPorFecha(LocalDateTime fechaPublicacion);
    void guardar(Libro libro);
    void guardar(Libro2 libro2);
    void actualizar (Libro libro);
    void eliminar(Integer id);
}
