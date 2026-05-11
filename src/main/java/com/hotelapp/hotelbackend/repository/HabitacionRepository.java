package com.hotelapp.hotelbackend.repository;

import com.hotelapp.hotelbackend.model.Habitacion;
import java.util.List;

public interface HabitacionRepository {

    Habitacion guardar(Habitacion habitacion);

    List<Habitacion> listar();

    Habitacion buscarPorId(Long id);

    List<Habitacion> listarPorHotel(Long hotelId);

    List<Habitacion> listarDisponiblesPorHotel(Long hotelId);

    void eliminar(Long id);
}