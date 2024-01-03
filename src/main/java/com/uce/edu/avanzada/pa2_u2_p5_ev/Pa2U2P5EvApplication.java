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

        this.iHotelService.guardar(hotel);


























    }
}
    //todo consultar sobre el manejo de transacciones
