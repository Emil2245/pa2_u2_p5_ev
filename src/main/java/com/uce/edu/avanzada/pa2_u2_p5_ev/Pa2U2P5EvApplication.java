package com.uce.edu.avanzada.pa2_u2_p5_ev;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Ciudadano;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Empleado;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Habitacion;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Hotel;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.ICiudadanoService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IEmpleadoService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IHabitacionService;
import com.uce.edu.avanzada.pa2_u2_p5_ev.service.IHotelService;
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
    private IHotelService iHotelService;

    @Autowired
    private IHabitacionService iHabitacionService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U2P5EvApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel hotel = new Hotel();
        hotel.setNombre("Hotel del Mar");
        hotel.setDireccion("a la orillita norte");

        Habitacion habitacion1 =new Habitacion();
        habitacion1.setClase("VIP");
        habitacion1.setHotel(hotel);
        habitacion1.setNumero("100");
        Habitacion habitacion2 = new Habitacion();
        habitacion2.setClase("Normie");
        habitacion2.setHotel(hotel);
        habitacion2.setNumero("101");
        List<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(habitacion1);
        habitaciones.add(habitacion2);

        hotel.setHabitaciones(habitaciones);

        //Insercion
        //        this.iHotelService.guardar(hotel);

        //Actualizacion
//        Hotel hotel1 = new Hotel();
//        hotel1.setNombre("Hotel Barataso");
//        hotel1.setDireccion("vecino del otro");
//        hotel1.setId(2);
//
//        Habitacion habitacion3 =new Habitacion();
//        habitacion3.setClase("Premium");
//        habitacion3.setHotel(hotel1);
//        habitacion3.setNumero("200");
//        habitacion3.setId(3);
//        Habitacion habitacion4 = new Habitacion();
//        habitacion4.setClase("Meh...");
//        habitacion4.setHotel(hotel1);
//        habitacion4.setNumero("210");
//        habitacion3.setId(4);
//        List<Habitacion> habitaciones2 = new ArrayList<>();
//        habitaciones2.add(habitacion3);
//        habitaciones2.add(habitacion4);
//
//        hotel1.setHabitaciones(habitaciones2);
//        this.iHotelService.actualizar(hotel1);

        //Busqueda
//        this.iHabitacionService.buscar(3);
//        this.iHabitacionService.buscar(4);
//        this.iHotelService.buscar(2);

        //Eliminar
        this.iHotelService.eliminar(2);
        this.iHabitacionService.eliminar(3);
        this.iHabitacionService.eliminar(4);





    }
}
