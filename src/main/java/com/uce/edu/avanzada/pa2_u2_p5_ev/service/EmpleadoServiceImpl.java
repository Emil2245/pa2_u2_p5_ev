package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.IEmpleadoRepository;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;
    @Override
    public Empleado buscar(Integer id) {
        return this.iEmpleadoRepository.seleccionar(id);
    }
    @Override
    public void guardar(Empleado empleado) {
        this.iEmpleadoRepository.insertar(empleado);
    }
//
//    @Override
//    public void actualizar(Estudiante estudiante) {
//        this.iEstudianteRepository.actualizar(estudiante);
//    }
//
//    @Override
//    public void eliminar(Integer id) {
//        this.iEstudianteRepository.eliminar(id);
//    }
}
