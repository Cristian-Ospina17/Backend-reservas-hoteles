package com.hotelapp.hotelbackend.repository;

import com.hotelapp.hotelbackend.model.Reserva;
import java.util.List;

public interface ReservaRepository {

    Reserva guardar(Reserva reserva);

    List<Reserva> listar();

    Reserva buscarPorId(Long id);

    Reserva actualizar(Long id, Reserva reserva);

    List<Reserva> filtrarPorEstado(String estado);

    void cambiarEstado(Long id, String estado);

    void eliminar(Long id);
}