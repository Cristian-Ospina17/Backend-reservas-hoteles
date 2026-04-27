package com.hotelapp.hotelbackend.service;

import com.hotelapp.hotelbackend.model.Reserva;
import java.util.List;

public interface ReservaService {

    Reserva crearReserva(Reserva reserva);

    List<Reserva> listar();

    Reserva buscar(Long id);

    Reserva actualizar(Long id, Reserva reserva);

    List<Reserva> filtrarPorEstado(String estado);

    Reserva cancelar(Long id);

    void eliminar(Long id);
}