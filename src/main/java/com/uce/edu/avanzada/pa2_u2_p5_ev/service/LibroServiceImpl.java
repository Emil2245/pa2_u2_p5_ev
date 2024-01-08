package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.ILibroRepository;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements ILibroService{
    @Autowired
    private ILibroRepository iLibroRepository;
    @Override
    public Libro buscar(Integer id) {
        return (Libro) this.iLibroRepository.seleccionar(id);
    }

    @Override
    public void guardar(Libro libro) {
        this.iLibroRepository.insertar(libro);
    }

    @Override
    public void actualizar(Libro libro) {
        this.iLibroRepository.actualizar(libro);
    }

    @Override
    public void eliminar(Integer id) {
        this.iLibroRepository.eliminar(id);

    }
}
