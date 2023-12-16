package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Alumno;

public interface IAlumnoRepository {
    Alumno seleccionar(Integer id);
    void insertar(Alumno alumno);
    void actualizar (Alumno alumno);
    void eliminar(Integer id);
}
