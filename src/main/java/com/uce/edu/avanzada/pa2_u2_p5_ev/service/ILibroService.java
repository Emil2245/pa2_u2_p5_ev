package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro2;

public interface ILibroService {
    Libro buscarPorNombre(String nombre);
    Libro buscar(Integer id);
    void guardar(Libro libro);
    void guardar(Libro2 libro2);
    void actualizar (Libro libro);
    void eliminar(Integer id);
}
