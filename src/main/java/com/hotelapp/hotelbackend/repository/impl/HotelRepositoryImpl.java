package com.hotelapp.hotelbackend.repository.impl;

import com.hotelapp.hotelbackend.model.Hotel;
import com.hotelapp.hotelbackend.repository.HotelRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HotelRepositoryImpl implements HotelRepository {

    private final Map<Long, Hotel> hoteles = new HashMap<>();
    private Long contadorId = 1L;

    @Override
    public Hotel guardar(Hotel hotel) {
        if (hotel.getId() == null) {
            hotel.setId(contadorId++);
        }

        hoteles.put(hotel.getId(), hotel);
        return hotel;
    }

    @Override
    public List<Hotel> listar() {
        return new ArrayList<>(hoteles.values());
    }

    @Override
    public Hotel buscarPorId(Long id) {
        return hoteles.get(id);
    }

    @Override
    public Hotel actualizar(Long id, Hotel hotel) {
        if (!hoteles.containsKey(id)) {
            throw new RuntimeException("Hotel no encontrado");
        }

        hotel.setId(id);
        hoteles.put(id, hotel);
        return hotel;
    }

    @Override
    public List<Hotel> filtrarPorCiudad(String ciudad) {
        List<Hotel> resultado = new ArrayList<>();

        for (Hotel h : hoteles.values()) {
            if (h.getCiudad() != null && h.getCiudad().equalsIgnoreCase(ciudad)) {
                resultado.add(h);
            }
        }

        return resultado;
    }

    @Override
    public void eliminar(Long id) {
        if (!hoteles.containsKey(id)) {
            throw new RuntimeException("Hotel no encontrado");
        }

        hoteles.remove(id);
    }
}