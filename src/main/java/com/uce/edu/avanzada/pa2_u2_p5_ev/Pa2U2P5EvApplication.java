package com.uce.edu.avanzada.pa2_u2_p5_ev;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Autor;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Libro;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IAutorService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Libro libro1 = new Libro("Python", LocalDateTime.now());
        Autor autor1 = new Autor("Humbertp", "Ecu");
        Autor autor2 = new Autor("Juano", "Colombiano");

//        List<Autor2> autores = new ArrayList<>();
//        autores.add(autor1);
//        autores.add(autor2);

//        AutorLibro autorLibro1 = new AutorLibro();
//        autorLibro1.setLibro2(libro1);
//        autorLibro1.setAutor2(autor1);
//        AutorLibro autorLibro2 = new AutorLibro();
//        autorLibro2.setLibro2(libro1);
//        autorLibro2.setAutor2(autor2);

        Set<Autor> lista = new HashSet<>();
        lista.add(autor1);
        lista.add(autor2);

        libro1.setAutores(lista);
//        System.out.println("--------------------------------------");
//        this.iLibroService.guardar(libro1);
        System.out.println("Query--------------------------------------");
        List<Libro> libroFinal = this.iLibroService.buscarPorFechaPublicacion(LocalDateTime.of(2023, 1, 1, 7, 15));
        libroFinal.forEach(System.out::println);
        System.out.println("Typed Query--------------------------------------");
        Libro libroTyped = this.iLibroService.buscarPorTitulo("GOT");
        System.out.println(libroTyped);
        System.out.println("Typed Query--------------------------------------");
        List<Libro> libroTypedLi = this.iLibroService.buscarPorFecha(LocalDateTime.of(2023, 1, 1, 7, 15));
        libroTypedLi.forEach(System.out::println);
        System.out.println("Named Query--------------------------------------");
        Libro libroNamed = this.iLibroService.buscarPorTitulo("Java");
        System.out.println(libroNamed);
        System.out.println("Named Query--------------------------------------");
        List<Libro> libroNamedLi = this.iLibroService.buscarPorFechaPublicacionNamed(LocalDateTime.of(2023, 1, 1, 7, 15));
        libroNamedLi.forEach(System.out::println);


    }
}
