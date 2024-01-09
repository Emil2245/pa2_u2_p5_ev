package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro2;

public interface ILibroRepository {
    Libro seleccionarPorNombre(String nombre);
    Libro seleccionar(Integer id);
    void insertar(Libro libro);
    void actualizar (Libro libro);
    void insertar(Libro2 libro2);
    void actualizar (Libro2 libro2);
    void eliminar(Integer id);
}
