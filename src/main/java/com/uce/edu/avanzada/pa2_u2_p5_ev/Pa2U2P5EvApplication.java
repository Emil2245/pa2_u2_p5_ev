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
        ciudadano.setApellido("Deber");
        ciudadano.setNombre("Numero 8");

        Empleado empleado = new Empleado();
        empleado.setSalario(new BigDecimal(500));
        empleado.setFechaIngreso(LocalDateTime.now());

        //Insercion
//        this.iCiudadanoService.guardar(ciudadano);
//        empleado.setCiudadano(this.iCiudadanoService.buscar(14));
//        this.iEmpleadoService.guardar(empleado);

        //Busqueda
//        this.iCiudadanoService.buscar(11);

        //Actualizacion
//        Empleado empleado2 = new Empleado();
//        empleado2.setSalario(new BigDecimal(8880));
//        empleado=this.iEmpleadoService.buscar(19);
//        this.iEmpleadoService.actualizar(empleado2);
//        Ciudadano ciudadano1 =new Ciudadano();
//        ciudadano1.setApellido("Tarea");
//        ciudadano1.setNombre("Numero 8");
//        this.iCiudadanoService.actualizar(11,ciudadano1);

        //Eliminar
//        this.iCiudadanoService.eliminar(11);
//        this.iEmpleadoService.eliminar(19);

        //Actualizar
        Ciudadano ciudadano2 = new Ciudadano();
        ciudadano2.setApellido("Tarea");
        ciudadano2.setNombre("Numero 8 Actualizada");
        ciudadano2.setId(14);
        Empleado empleado2 = new Empleado();
        empleado2.setSalario(new BigDecimal(5000000));
        empleado2.setFechaIngreso(LocalDateTime.now());
        empleado2.setId(23);
        empleado2.setCiudadano(this.iCiudadanoService.buscar(14));

        this.iCiudadanoService.actualizar(ciudadano2);
        this.iEmpleadoService.actualizar(empleado2);



    }
}
