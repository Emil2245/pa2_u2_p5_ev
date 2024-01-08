package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Autor;

public interface IAutorRepository {
    Autor select(Integer id);
    void insert(Autor autor);
    void update (Autor autor);
    void delete(Integer id);
}
