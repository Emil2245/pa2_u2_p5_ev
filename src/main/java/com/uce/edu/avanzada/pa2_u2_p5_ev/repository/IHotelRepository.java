package com.uce.edu.avanzada.pa2_u2_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u2_p5_ev.repository.modelo.Hotel;

public interface IHotelRepository {
    Hotel seleccionar(Integer id);
    void insertar(Hotel hotel);
    void actualizar (Hotel hotel);
    void eliminar(Integer id);
}
