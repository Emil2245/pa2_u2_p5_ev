package com.uce.edu.avanzada.pa2_u2_p5_ev;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IAutorService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.ICiudadanoService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {

    @Autowired
    private ILibroService iLibroService;
    @Autowired
    private IAutorService iAutorService;
    @Autowired
    private ICiudadanoService iCiudadanoService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5EvApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Empleado empleado = new Empleado();
        empleado.setFechaIngreso(LocalDateTime.now());
        empleado.setSalario(new BigDecimal(70000000));
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setCedula("76845");
        ciudadano.setNombre("Samy");
        ciudadano.setApellido("Veloz");
        ciudadano.setEmpleado(empleado);
        empleado.setCiudadano(ciudadano);
//        this.iCiudadanoService.guardar(ciudadano);

        System.out.println(
                this.iCiudadanoService.buscarPorCedula("76845").toString()
        );
        System.out.println(
                this.iCiudadanoService.buscarPorCedulaCiu("76845").toString()
        );

    }
}
