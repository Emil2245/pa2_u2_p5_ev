package com.uce.edu.avanzada.pa2_u2_p5_ev;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Alumno;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Estudiante;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IAlumnoService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.AbstractList;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {

    @Autowired
    private IEstudianteService iEstudianteService;

    @Autowired
    private IAlumnoService iAlumnoService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5EvApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Estudiante estudiante0 = new Estudiante();
        estudiante0.setApellido("Verkade");
        estudiante0.setCedula("159844621");
        estudiante0.setNombre("Emil");
        estudiante0.setFechaNacimiento(LocalDateTime.of(
                2002, 02, 17, 00, 01, 55));

//        this.iEstudianteService.guardar(estudiante0);
//        Estudiante estudiante1 = this.iEstudianteService.buscar(9);
//        this.iEstudianteService.buscar(estudiante1.getId());
//        estudiante1.setNombre("Emiliano");
//        this.iEstudianteService.actualizar(estudiante1);

//        this.iEstudianteService.eliminar(9);


        Alumno alumno = new Alumno();
        alumno.setId(5);
        alumno.setNombre("Juan");
//        this.iAlumnoService.guardar(alumno);

        Alumno alumno1=this.iAlumnoService.buscar(alumno.getId());
        alumno1.setNombre("peptito");
        this.iAlumnoService.actualizar(alumno1);

//        this.iAlumnoService.eliminar(alumno.getId());


    }
    //todo consultar sobre el manejo de transacciones
}
