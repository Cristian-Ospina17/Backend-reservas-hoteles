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

        return repository.save(hotel);
    }

    @Override
    public List<Hotel> listar() {
        return repository.findAll();
    }

    @Override
    public Hotel buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado"));
    }

    @Override
    public Hotel actualizar(Long id, Hotel hotel) {

        Hotel existente = buscar(id);

        existente.setNombre(hotel.getNombre());
        existente.setCiudad(hotel.getCiudad());
        existente.setPrecioPorNoche(hotel.getPrecioPorNoche());
        existente.setCategoria(hotel.getCategoria());

        existente.setImagen(hotel.getImagen());
        existente.setDescripcion(hotel.getDescripcion());

        existente.setCantidadHabitaciones(hotel.getCantidadHabitaciones());
        existente.setBanos(hotel.getBanos());
        existente.setPersonasMax(hotel.getPersonasMax());

        existente.setCaracteristicas(hotel.getCaracteristicas());

        return repository.save(existente);
    }

    @Override
    public List<Hotel> filtrarPorCiudad(String ciudad) {
        return repository.findByCiudadIgnoreCase(ciudad);
    }

    @Override
    public void eliminar(Long id) {

        Hotel hotel = buscar(id);

        repository.delete(hotel);
    }
}