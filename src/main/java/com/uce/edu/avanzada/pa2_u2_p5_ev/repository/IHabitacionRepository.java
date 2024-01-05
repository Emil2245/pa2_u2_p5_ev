package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Habitacion;

public interface IHabitacionRepository {
    Habitacion seleccionar(Integer id);
    void insertar(Habitacion habitacion);
    void actualizar (Habitacion habitacion);
    void eliminar(Integer id);
}
