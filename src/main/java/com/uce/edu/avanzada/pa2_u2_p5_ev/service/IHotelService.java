package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Habitacion;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Hotel;

import java.util.List;

public interface IHotelService {
    Hotel buscar(Integer id);
    List<Habitacion> buscarTodasHabitaciones(String nombre);
    List<Habitacion> buscarHabitacionesEntre(String nombre,Integer min, Integer max);
    Hotel buscarHotelPorNombre(String name);
    List<Hotel> buscarHotelConPiscina();
    List<Hotel> buscarHotelSinPiscina();
    Hotel buscarHotelPorDireccion(String direccion);
    List<Hotel> buscarHotelesPorNumHabitaciones(Integer num);
    List<Habitacion> buscarHabitacionesConVistaPiscina(String name);
    List<Habitacion> buscarHabitacionesSinVistaPiscina(String name);
    Integer contarHabitacionesPorHotel(String name);
    void guardar(Hotel hotel);
    void actualizar (Hotel hotel);
    void eliminar(Integer id);

}
