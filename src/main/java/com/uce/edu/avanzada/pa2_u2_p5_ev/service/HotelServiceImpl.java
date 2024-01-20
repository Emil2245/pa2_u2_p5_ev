package com.uce.edu.avanzada.pa2_u2_p5_ev.service;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.IHotelRepository;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Habitacion;
import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService{
    @Autowired
    private IHotelRepository iHotelRepository;
    @Override
    public Hotel buscar(Integer id) {
        return this.iHotelRepository.seleccionar(id);
    }

    @Override
    public List<Habitacion> buscarTodasHabitaciones(String nombre) {
        return this.iHotelRepository.selectAllRooms(nombre);
    }

    @Override
    public List<Habitacion> buscarHabitacionesEntre(String nombre, Integer min, Integer max) {
        return this.iHotelRepository.selectRoomsInBetween(nombre, min, max);
    }

    @Override
    public Hotel buscarHotelPorNombre(String name) {
        return this.iHotelRepository.selectHotelByName(name);
    }

    @Override
    public List<Hotel> buscarHotelConPiscina() {
        return this.iHotelRepository.selectHotelConPiscina();
    }

    @Override
    public List<Hotel> buscarHotelSinPiscina() {
        return this.iHotelRepository.selectHotelSinPiscina();
    }

    @Override
    public Hotel buscarHotelPorDireccion(String direccion) {
        return this.iHotelRepository.selectHotelPorDireccion(direccion);
    }

    @Override
    public List<Hotel> buscarHotelesPorNumHabitaciones(Integer num) {
        return this.iHotelRepository.selectHotelesPorNumHabitaciones(num);
    }

    @Override
    public List<Habitacion> buscarHabitacionesConVistaPiscina(String name) {
        return this.iHotelRepository.selectHabitacionesConVistaPiscina(name);
    }

    @Override
    public List<Habitacion> buscarHabitacionesSinVistaPiscina(String name) {
        return this.iHotelRepository.selectHabitacionesSinVistaPiscina(name);
    }

    @Override
    public Integer contarHabitacionesPorHotel(String name){
        return this.iHotelRepository.countHabitacionesPorHotel(name);
    }

    @Override
    public void guardar(Hotel hotel) {
        this.iHotelRepository.insertar(hotel);
    }

    @Override
    public void actualizar(Hotel hotel) {
        this.iHotelRepository.actualizar(hotel);
    }

    @Override
    public void eliminar(Integer id) {
        this.iHotelRepository.eliminar(id);
    }
}
