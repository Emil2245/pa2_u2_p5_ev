package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.ICiudadanoRepository;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.ICiudadanoRepository;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
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
    public void guardar(Ciudadano ciudadano) {
        this.iCiudadanoRepository.insertar(ciudadano);
    }

    @Override
    public void actualizar(Ciudadano ciudadano) {
        this.iCiudadanoRepository.actualizar(ciudadano);
    }

    @Override
    public void eliminar(Integer id) {
        this.iCiudadanoRepository.eliminar(id);
    }
}
