package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;

public interface IEmpleadoService {
    Empleado buscar(Integer id);
    void guardar(Empleado empleado);
    void actualizar (Empleado empleado);
    void eliminar(Integer id);
}
