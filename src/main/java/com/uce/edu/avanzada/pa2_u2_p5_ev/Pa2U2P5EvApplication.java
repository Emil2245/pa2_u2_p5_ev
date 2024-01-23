package com.uce.edu.avanzada.pa2_u2_p5_ev;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IHabitacionService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class Pa2U2P5EvApplication implements CommandLineRunner {

    @Autowired
    private IHabitacionService iHabitacionService;
    @Autowired
    private IHotelService iHotelService;

    @Autowired

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5EvApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Empleado empleado = new Empleado();
        empleado.setFechaIngreso(LocalDateTime.now());
        empleado.setSalario(new BigDecimal(5000));
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setCedula("0500000");
        ciudadano.setNombre("Emil");
        ciudadano.setApellido("Cotopaxi");
        ciudadano.setEmpleado(empleado);
        empleado.setCiudadano(ciudadano);

        System.out.println(this.iHotelService.buscarHotelesPorNombre("Hotel del Mar"));
        System.out.println("---------------------------------------------");
        System.out.println(this.iHotelService.buscarHotelesConPiscina());
        System.out.println("---------------------------------------------");
        System.out.println(this.iHotelService.buscarHabitacionesConVistaPiscina());
        System.out.println("---------------------------------------------");
        System.out.println(this.iHotelService.buscarHabitacionesEnHotelesPorDireccion("norte del otro"));
        System.out.println("---------------------------------------------");
        System.out.println(this.iHotelService.buscarHotelesConHabitacionesVistaPiscina());

    }
}
