package com.uce.edu.avanzada.pa2_u2_p5_ev;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Autor2;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.AutorLibro;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro2;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IAutorService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {

    @Autowired
    private ILibroService iLibroService;
    @Autowired
    private IAutorService iAutorService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5EvApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Libro2 libro1 = new Libro2("GOT", LocalDateTime.now());
        Autor2 autor1 = new Autor2("Pepito Perez", "Ecu");
        Autor2 autor2 = new Autor2("Juan teran", "Colombiano");

//        List<Autor2> autores = new ArrayList<>();
//        autores.add(autor1);
//        autores.add(autor2);

        AutorLibro autorLibro1 = new AutorLibro();
        autorLibro1.setLibro2(libro1);
        autorLibro1.setAutor2(autor1);
        AutorLibro autorLibro2 = new AutorLibro();
        autorLibro2.setLibro2(libro1);
        autorLibro2.setAutor2(autor2);

        List<AutorLibro> lista= new ArrayList<>();
        lista.add(autorLibro1);
        lista.add(autorLibro2);

        libro1.setAutoresLibros(lista);


//        this.iLibroService.guardar(libro1);
        Libro libroFinal=this.iLibroService.buscarPorNombre("GOT");
        System.out.println(libroFinal);

    }
}
