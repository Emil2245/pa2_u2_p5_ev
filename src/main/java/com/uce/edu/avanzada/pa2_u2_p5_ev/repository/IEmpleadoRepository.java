package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;

public interface IEmpleadoRepository {
    Empleado seleccionar(Integer id);
    void insertar(Empleado empleado);
    void actualizar (Empleado empleado);
    void eliminar(Integer id);
}
