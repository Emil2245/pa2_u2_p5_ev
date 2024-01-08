package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.IAutorRepository;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements IAutorService{
    @Autowired
    private IAutorRepository iAutorRepository;

    @Override
    public void guardar(Autor autor) {
        this.iAutorRepository.insert(autor);
    }

    @Override
    public Autor buscar(Integer id) {
        return this.iAutorRepository.select(id);
    }

    @Override
    public void borrar(Integer id) {
        this.iAutorRepository.delete(id);
    }

    @Override
    public void actualizar(Autor autor) {
        this.iAutorRepository.update(autor);
    }
}
