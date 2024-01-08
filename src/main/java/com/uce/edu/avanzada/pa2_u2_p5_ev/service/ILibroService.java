package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;

public interface ILibroService {
    Libro buscar(Integer id);
    void guardar(Libro libro);
    void actualizar (Libro libro);
    void eliminar(Integer id);
}
