package com.hotelapp.hotelbackend.service.impl;

import com.hotelapp.hotelbackend.model.Habitacion;
import com.hotelapp.hotelbackend.repository.HabitacionRepository;
import com.hotelapp.hotelbackend.service.HabitacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionServiceImpl implements HabitacionService {

    private final HabitacionRepository repository;

    public HabitacionServiceImpl(HabitacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Habitacion crearHabitacion(Habitacion habitacion) {

        if (habitacion.getHotelId() == null) {
            throw new RuntimeException("El hotelId es requerido");
        }

        if (habitacion.getNumero() <= 0) {
            throw new RuntimeException("El número de habitación debe ser mayor a 0");
        }

        if (habitacion.getCategoria() == null || habitacion.getCategoria().isEmpty()) {
            throw new RuntimeException("La categoría es requerida");
        }

        if (habitacion.getPrecio() <= 0) {
            throw new RuntimeException("El precio debe ser mayor a 0");
        }

        return repository.guardar(habitacion);
    }

    @Override
    public List<Habitacion> listar() {
        return repository.listar();
    }

    @Override
    public Habitacion buscar(Long id) {
        Habitacion habitacion = repository.buscarPorId(id);

        if (habitacion == null) {
            throw new RuntimeException("Habitación no encontrada");
        }

        return habitacion;
    }

    @Override
    public List<Habitacion> listarPorHotel(Long hotelId) {
        return repository.listarPorHotel(hotelId);
    }

    @Override
    public List<Habitacion> listarDisponiblesPorHotel(Long hotelId) {
        return repository.listarDisponiblesPorHotel(hotelId);
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}