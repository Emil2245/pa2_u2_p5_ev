package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Alumno;

public interface IAlumnoService {
    Alumno buscar(Integer id);
    void guardar(Alumno estudiante);
    void actualizar (Alumno estudiante);
    void eliminar(Integer id);
}
