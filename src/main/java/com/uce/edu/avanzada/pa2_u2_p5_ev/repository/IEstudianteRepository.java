package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    Estudiante seleccionar(Integer id);
    void insertar(Estudiante estudiante);
    void actualizar (Estudiante estudiante);
    void eliminar(Integer id);
}
