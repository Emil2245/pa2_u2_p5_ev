package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Autor;

public interface IAutorRepository {
    Autor seleccionar(Integer id);
    void insertar(Autor autor);
    void actualizar (Autor autor);
    void eliminar(Integer id);
}
