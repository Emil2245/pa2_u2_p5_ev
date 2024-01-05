package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Habitacion;

public interface IHabitacionService {
    Habitacion buscar(Integer id);
    void guardar(Habitacion habitacion);
    void actualizar (Habitacion habitacion);
    void eliminar(Integer id);
}
