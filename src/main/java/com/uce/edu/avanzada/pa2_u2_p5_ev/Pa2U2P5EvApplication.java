package com.uce.edu.avanzada.pa2_u2_p5_ev;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Autor;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IHabitacionService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {

    @Autowired
    private ILibroService iLibroService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5EvApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Libro libro1 = new Libro("GOT", LocalDateTime.now());
        Autor autor1 = new Autor("Pepito Perez", "Ecu");
        Autor autor2 = new Autor("Juan teran", "Colombiano");

        Set<Autor> autores = new HashSet<>();
        autores.add(autor1);
        autores.add(autor2);
        libro1.setAutores(autores);

        Set<Libro> libros = new HashSet<>();
        libros.add(libro1);
//        autor1.setLibros(libros);
//        autor2.setLibros(libros);

        iLibroService.guardar(libro1);


    }
}
