package com.hotelapp.hotelbackend.service.impl;

import com.hotelapp.hotelbackend.model.Hotel;
import com.hotelapp.hotelbackend.repository.HotelRepository;
import com.hotelapp.hotelbackend.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;

    public HotelServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Hotel crearHotel(Hotel hotel) {

        if (hotel.getNombre() == null || hotel.getNombre().isEmpty()) {
            throw new RuntimeException("Nombre del hotel requerido");
        }

        if (hotel.getCiudad() == null || hotel.getCiudad().isEmpty()) {
            throw new RuntimeException("Ciudad requerida");
        }

        if (hotel.getPrecioPorNoche() <= 0) {
            throw new RuntimeException("El precio por noche debe ser mayor a 0");
        }

        return repository.guardar(hotel);
    }

    @Override
    public List<Hotel> listar() {
        return repository.listar();
    }

    @Override
    public Hotel buscar(Long id) {
        Hotel hotel = repository.buscarPorId(id);

        if (hotel == null) {
            throw new RuntimeException("Hotel no encontrado");
        }

        return hotel;
    }

    @Override
    public Hotel actualizar(Long id, Hotel hotel) {
        return repository.actualizar(id, hotel);
    }

    @Override
    public List<Hotel> filtrarPorCiudad(String ciudad) {
        return repository.filtrarPorCiudad(ciudad);
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}