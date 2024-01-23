package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.ICiudadanoRepository;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {
    @Autowired
    private ICiudadanoRepository iCiudadanoRepository;

    @Override
    public Ciudadano buscar(Integer id) {
        return this.iCiudadanoRepository.seleccionar(id);
    }

    @Override
    public Ciudadano buscarPorCedulaCiu(String id) {
        return this.iCiudadanoRepository.seleccionarPorCedulaCiu(id);
    }

    @Override
    public Ciudadano buscarPorApellido(String apellido) {
        return this.iCiudadanoRepository.seleccionarPorApellido(apellido);
    }

    @Override
    public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula) {
        return this.iCiudadanoRepository.seleccionarPorCriteria(nombre, apellido, cedula);
    }

    @Override
    public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
        return this.iCiudadanoRepository.seleccionarPorCriteriaAndOr(nombre, apellido, cedula);
    }

    @Override
    public void guardar(Ciudadano ciudadano) {
        this.iCiudadanoRepository.insertar(ciudadano);
    }

    @Override
    public void actualizar(Ciudadano estudiante) {
        this.iCiudadanoRepository.actualizar(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.iCiudadanoRepository.eliminar(id);
    }

    @Override
    public Empleado buscarPorCedula(String cedula) {
        return this.iCiudadanoRepository.seleccionarEmpleadoPorCedula(cedula);
    }
}
