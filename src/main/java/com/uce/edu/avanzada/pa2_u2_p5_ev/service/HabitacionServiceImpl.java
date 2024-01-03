package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.IHabitacionRepository;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Habitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitacionServiceImpl implements IHabitacionService{
    @Autowired
    private IHabitacionRepository iHabitacionRepository;
//    @Override
//    public Habitacion buscar(Integer id) {
//        return this.iHabitacionRepository.seleccionar(id);
//    }

    @Override
    public void guardar(Habitacion habitacion) {
        this.iHabitacionRepository.insertar(habitacion);
    }
//
//    @Override
//    public void actualizar(Habitacion habitacion) {
//        this.iHabitacionRepository.actualizar(habitacion);
//    }
//
//    @Override
//    public void eliminar(Integer id) {
//        this.iHabitacionRepository.eliminar(id);
//    }
}
