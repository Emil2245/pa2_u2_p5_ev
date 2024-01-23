package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;

public interface ICiudadanoService {
    Ciudadano buscar(Integer id);
    Ciudadano buscarPorCedulaCiu(String id);
    Ciudadano buscarPorApellido(String apellido);
    Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula);
    Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula);
    void guardar(Ciudadano ciudadano);
    void actualizar (Ciudadano ciudadano);
    void eliminar(Integer id);
    Empleado buscarPorCedula(String cedula);
}
