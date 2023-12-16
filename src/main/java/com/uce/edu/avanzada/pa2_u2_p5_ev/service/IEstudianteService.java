package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Estudiante;

public interface IEstudianteService {
    Estudiante buscar(Integer id);
    void guardar(Estudiante estudiante);
    void actualizar (Estudiante estudiante);
    void eliminar(Integer id);
}
