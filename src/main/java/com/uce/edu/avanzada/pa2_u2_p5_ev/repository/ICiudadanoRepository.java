package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {
    Ciudadano seleccionar(Integer id);

    void insertar(Ciudadano ciudadano);

    void actualizar(Ciudadano ciudadano);

    void eliminar(Integer id);
}
