package com.uce.edu.avanzada.pa2_u2_p5_ev;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Alumno;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Estudiante;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IAlumnoService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.ICiudadanoService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IEmpleadoService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.AbstractList;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {

    @Autowired
    private IEmpleadoService iEmpleadoService;

    @Autowired
    private ICiudadanoService iCiudadanoService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5EvApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setApellido("Verkade");
        ciudadano.setNombre("Emil");

        Empleado empleado = new Empleado();
        empleado.setSalario(new BigDecimal(500));
        empleado.setFechaIngreso(LocalDateTime.now());

//        iCiudadanoService.guardar(ciudadano);

        System.out.println(
                this.iCiudadanoService.buscar(1)
        );

        empleado.setCiudadano(this.iCiudadanoService.buscar(1));
//        this.iEmpleadoService.guardar(empleado);
//        System.out.println(
//                this.iEmpleadoService.buscar(4)
//        );















    }
}
    //todo consultar sobre el manejo de transacciones
