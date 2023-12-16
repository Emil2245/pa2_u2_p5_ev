package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.IAlumnoRepository;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements IAlumnoService{
    @Autowired
    private IAlumnoRepository iAlumnoRepository;
    @Override
    public Alumno buscar(Integer id) {
        return this.iAlumnoRepository.seleccionar(id);
    }

    @Override
    public void guardar(Alumno alumno) {
        this.iAlumnoRepository.insertar(alumno);
    }

    @Override
    public void actualizar(Alumno alumno) {
        this.iAlumnoRepository.actualizar(alumno);
    }

    @Override
    public void eliminar(Integer id) {
        this.iAlumnoRepository.eliminar(id);
    }
}
