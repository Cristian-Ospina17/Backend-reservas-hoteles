package com.hotelapp.hotelbackend.service;

import com.hotelapp.hotelbackend.model.Hotel;
import java.util.List;

public interface HotelService {

    Hotel crearHotel(Hotel hotel);

    List<Hotel> listar();

    Hotel buscar(Long id);

    Hotel actualizar(Long id, Hotel hotel);

    List<Hotel> filtrarPorCiudad(String ciudad);

    void eliminar(Long id);
}