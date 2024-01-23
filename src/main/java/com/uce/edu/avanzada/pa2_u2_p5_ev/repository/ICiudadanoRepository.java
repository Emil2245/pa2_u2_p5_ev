package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;

public interface ICiudadanoRepository {
    Ciudadano seleccionar(Integer id);
    Ciudadano seleccionarPorCedulaCiu(String id);
    Ciudadano seleccionarPorApellido(String apellido);
    //Cuando el Ciudadano sea de Pichincha, busque por nombre
    //Cuando el Ciudadano sea de Cotopaxi, busque por apellido
    //Cuando el Ciudadano no sea ni Pichincha, ni Cotopaxi, busque por cedula
    Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula);
    Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);
    Empleado seleccionarEmpleadoPorCedula(String cedula);
    void insertar(Ciudadano ciudadano);

    void actualizar(Ciudadano ciudadano);

    void eliminar(Integer id);

}
