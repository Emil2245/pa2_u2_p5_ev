package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.IEstudianteRepository;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
    @Autowired
    private IEstudianteRepository iEstudianteRepository;
    @Override
    public Estudiante buscar(Integer id) {
        return this.iEstudianteRepository.seleccionar(id);
    }

    @Override
    public void guardar(Estudiante estudiante) {
        this.iEstudianteRepository.insertar(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.iEstudianteRepository.actualizar(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.iEstudianteRepository.eliminar(id);
    }
}
