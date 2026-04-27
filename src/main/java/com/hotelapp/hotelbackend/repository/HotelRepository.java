package com.hotelapp.hotelbackend.repository;

import com.hotelapp.hotelbackend.model.Hotel;
import java.util.List;

public interface HotelRepository {

    Hotel guardar(Hotel hotel);

    List<Hotel> listar();

    Hotel buscarPorId(Long id);

    Hotel actualizar(Long id, Hotel hotel);

    List<Hotel> filtrarPorCiudad(String ciudad);

    void eliminar(Long id);
}