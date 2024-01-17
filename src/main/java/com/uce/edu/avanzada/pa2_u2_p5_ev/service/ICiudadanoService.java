package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;

public interface ICiudadanoService {
    Ciudadano buscar(Integer id);
    Ciudadano buscarPorCedulaCiu(String id);
    void guardar(Ciudadano ciudadano);
    void actualizar (Ciudadano ciudadano);
    void eliminar(Integer id);
    Empleado buscarPorCedula(String cedula);
}
