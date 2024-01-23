package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Habitacion;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Hotel;

import java.util.List;

public interface IHotelRepository {
    Hotel seleccionar(Integer id);

    List<Habitacion> selectAllRooms(String nombre);

    List<Habitacion> selectRoomsInBetween(String nombre, Integer min, Integer max);

    Hotel selectHotelByName(String name);

    Hotel selectHotelPorDireccion(String direccion);

    List<Hotel> selectHotelesPorNumHabitaciones(Integer num);

    List<Hotel> selectHotelConPiscina();

    List<Hotel> selectHotelSinPiscina();

    List<Habitacion> selectHabitacionesConVistaPiscina(String name);

    List<Habitacion> selectHabitacionesSinVistaPiscina(String name);

    Integer countHabitacionesPorHotel(String name);

    List<Hotel> selectHotelesPorNombre(String nombre);
    List<Hotel> selectHotelesConPiscina();
    List<Habitacion> selectHabitacionesConVistaPiscina();
    List<Hotel> selectHotelesConHabitacionesVistaPiscina();
    List<Habitacion> selectHabitacionesEnHotelesPorDireccion(String direccion);

    void insertar(Hotel hotel);

    void actualizar(Hotel hotel);

    void eliminar(Integer id);
}
