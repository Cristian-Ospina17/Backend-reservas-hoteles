package com.hotelapp.hotelbackend.service;

import com.hotelapp.hotelbackend.model.Habitacion;
import java.util.List;

public interface HabitacionService {

    Habitacion crearHabitacion(Habitacion habitacion);

    List<Habitacion> listar();

    Habitacion buscar(Long id);

    List<Habitacion> listarPorHotel(Long hotelId);

    List<Habitacion> listarDisponiblesPorHotel(Long hotelId);

    void eliminar(Long id);
}