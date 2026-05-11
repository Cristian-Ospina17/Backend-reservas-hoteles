package com.hotelapp.hotelbackend.repository.impl;

import com.hotelapp.hotelbackend.model.Habitacion;
import com.hotelapp.hotelbackend.repository.HabitacionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HabitacionRepositoryImpl implements HabitacionRepository {

    private final Map<Long, Habitacion> habitaciones = new HashMap<>();
    private Long contadorId = 1L;

    @Override
    public Habitacion guardar(Habitacion habitacion) {
        if (habitacion.getId() == null) {
            habitacion.setId(contadorId++);
        }

        habitaciones.put(habitacion.getId(), habitacion);
        return habitacion;
    }

    @Override
    public List<Habitacion> listar() {
        return new ArrayList<>(habitaciones.values());
    }

    @Override
    public Habitacion buscarPorId(Long id) {
        return habitaciones.get(id);
    }

    @Override
    public List<Habitacion> listarPorHotel(Long hotelId) {
        List<Habitacion> resultado = new ArrayList<>();

        for (Habitacion h : habitaciones.values()) {
            if (h.getHotelId().equals(hotelId)) {
                resultado.add(h);
            }
        }

        return resultado;
    }

    @Override
    public List<Habitacion> listarDisponiblesPorHotel(Long hotelId) {
        List<Habitacion> resultado = new ArrayList<>();

        for (Habitacion h : habitaciones.values()) {
            if (h.getHotelId().equals(hotelId) && h.isDisponible()) {
                resultado.add(h);
            }
        }

        return resultado;
    }

    @Override
    public void eliminar(Long id) {
        habitaciones.remove(id);
    }
}