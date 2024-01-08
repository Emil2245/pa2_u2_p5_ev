package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Autor;

public interface IAutorService {
    void guardar(Autor autor);
    Autor buscar(Integer id);
    void borrar(Integer id);
    void actualizar(Autor autor);
}
