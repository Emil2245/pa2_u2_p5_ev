package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Autor;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Autor2;

public interface IAutorRepository {
    Autor select(Integer id);
    void insert(Autor autor);
    void insert(Autor2 autor2);
    void update (Autor autor);
    void update (Autor2 autor2);
    void delete(Integer id);
}
