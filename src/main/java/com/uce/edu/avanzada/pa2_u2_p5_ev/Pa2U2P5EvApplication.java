package com.uce.edu.avanzada.pa2_u2_p5_ev;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.*;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        empleado.setSalario(new BigDecimal(70000000));
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setCedula("76845");
        ciudadano.setNombre("Samy");
        ciudadano.setApellido("Veloz");
        ciudadano.setEmpleado(empleado);
        empleado.setCiudadano(ciudadano);

        Hotel hotel = new Hotel();
        hotel.setNombre("Hotel del Mar");
        hotel.setTienePiscina(true);
        hotel.setDireccion("a la orillita norte");
        Habitacion habitacion1 = new Habitacion();
        habitacion1.setClase("VIP");
        habitacion1.setHotel(hotel);
        habitacion1.setTieneVistaPiscina(true);
        habitacion1.setNumero("100");
        Habitacion habitacion2 = new Habitacion();
        habitacion2.setTieneVistaPiscina(false);
        habitacion2.setClase("Normie");
        habitacion2.setHotel(hotel);
        habitacion2.setNumero("101");
        List<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(habitacion1);
        habitaciones.add(habitacion2);
        hotel.setHabitaciones(habitaciones);

        Hotel hotel1 = new Hotel();
        hotel1.setNombre("Hotel 2");
        hotel1.setTienePiscina(false);
        hotel1.setDireccion("norte del otro");
        Habitacion habitacion3 = new Habitacion();
        habitacion3.setTieneVistaPiscina(false);
        habitacion3.setClase("MMMM");
        habitacion3.setHotel(hotel1);
        habitacion3.setNumero("301");
        Habitacion habitacion4 = new Habitacion();
        habitacion4.setTieneVistaPiscina(false);
        habitacion4.setClase("Normie");
        habitacion4.setHotel(hotel1);
        habitacion4.setNumero("401");
        List<Habitacion> habitaciones2 = new ArrayList<>();
        habitaciones.add(habitacion3);
        habitaciones.add(habitacion4);
        hotel1.setHabitaciones(habitaciones2);

        Hotel hotel2 = new Hotel();
        hotel2.setNombre("Hotel del Azul");
        hotel2.setTienePiscina(true);
        hotel2.setDireccion("vecino del otro");
        Habitacion habitacion5 = new Habitacion();
        habitacion5.setClase("VIP+");
        habitacion5.setHotel(hotel2);
        habitacion5.setTieneVistaPiscina(true);
        habitacion5.setNumero("1001");
        Habitacion habitacion6 = new Habitacion();
        habitacion6.setTieneVistaPiscina(false);
        habitacion6.setClase("Normie");
        habitacion6.setHotel(hotel2);
        habitacion6.setNumero("1010");
        List<Habitacion> habitaciones3 = new ArrayList<>();
        habitaciones3.add(habitacion5);
        habitaciones3.add(habitacion6);
        hotel2.setHabitaciones(habitaciones3);

        Hotel hotel3 = new Hotel();
        hotel3.setNombre("Hotel Morado");
        hotel3.setTienePiscina(false);
        hotel3.setDireccion("vecino del vecino del otro");
        Habitacion habitacion7 = new Habitacion();
        habitacion7.setClase("VIP++");
        habitacion7.setHotel(hotel3);
        habitacion7.setTieneVistaPiscina(false);
        habitacion7.setNumero("1");
        Habitacion habitacion8 = new Habitacion();
        habitacion8.setTieneVistaPiscina(false);
        habitacion8.setClase("Normie");
        habitacion8.setHotel(hotel3);
        habitacion8.setNumero("10");
        List<Habitacion> habitaciones4 = new ArrayList<>();
        habitaciones4.add(habitacion7);
        habitaciones4.add(habitacion8);
        hotel3.setHabitaciones(habitaciones4);

//        this.iHotelService.guardar(hotel);
//        this.iHotelService.guardar(hotel1);
//        this.iHotelService.guardar(hotel2);
//        this.iHotelService.guardar(hotel3);

        System.out.println(
                this.iHotelService.buscarTodasHabitaciones("Hotel Morado")
        );
        System.out.println(
                this.iHotelService.buscarHabitacionesEntre("Hotel Morado",0,2)
        );
        System.out.println(
                this.iHotelService.buscarHotelPorNombre("Hotel Morado")
        );
        System.out.println(
                this.iHotelService.buscarHotelConPiscina()
        );
        System.out.println(
                this.iHotelService.buscarHotelSinPiscina()
        );
        System.out.println(
                this.iHotelService.buscarHotelPorDireccion("vecino del otro")
        );
        System.out.println(
                this.iHotelService.buscarHotelesPorNumHabitaciones(2)
        );
        System.out.println(
                this.iHotelService.buscarHabitacionesConVistaPiscina("Hotel del Mar")
        );
        System.out.println(
                this.iHotelService.buscarHabitacionesSinVistaPiscina("Hotel Morado")
        );
        System.out.println(
                this.iHotelService.contarHabitacionesPorHotel("Hotel Morado")
        );

    }
}
