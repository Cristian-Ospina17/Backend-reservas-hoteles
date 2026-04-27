package com.hotelapp.hotelbackend.service.impl;

import com.hotelapp.hotelbackend.factory.ReservaFactory;
import com.hotelapp.hotelbackend.model.Reserva;
import com.hotelapp.hotelbackend.repository.ReservaRepository;
import com.hotelapp.hotelbackend.service.ReservaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository repository;

    public ReservaServiceImpl(ReservaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reserva crearReserva(Reserva reserva) {

        if (reserva.getNombreUsuario() == null || reserva.getNombreUsuario().isEmpty()) {
            throw new RuntimeException("Nombre requerido");
        }

        if (reserva.getHotel() == null || reserva.getHotel().isEmpty()) {
            throw new RuntimeException("Hotel requerido");
        }

        if (reserva.getFechaEntrada() == null || reserva.getFechaSalida() == null) {
            throw new RuntimeException("Fechas requeridas");
        }

        if (!reserva.getFechaEntrada().isBefore(reserva.getFechaSalida())) {
            throw new RuntimeException("Fechas inválidas");
        }

        Reserva nueva = ReservaFactory.crear(
                reserva.getNombreUsuario(),
                reserva.getHotel(),
                reserva.getFechaEntrada(),
                reserva.getFechaSalida()
        );

        return repository.guardar(nueva);
    }

    @Override
    public List<Reserva> listar() {
        return repository.listar();
    }

    @Override
    public Reserva buscar(Long id) {
        Reserva reserva = repository.buscarPorId(id);

        if (reserva == null) {
            throw new RuntimeException("Reserva no encontrada");
        }

        return reserva;
    }

    @Override
    public Reserva actualizar(Long id, Reserva nueva) {
        Reserva existente = repository.buscarPorId(id);

        if (existente == null) {
            throw new RuntimeException("No existe la reserva");
        }

        nueva.setEstado(existente.getEstado());

        return repository.actualizar(id, nueva);
    }

    @Override
    public List<Reserva> filtrarPorEstado(String estado) {
        return repository.filtrarPorEstado(estado);
    }

    @Override
    public Reserva cancelar(Long id) {
        repository.cambiarEstado(id, "CANCELADA");
        return repository.buscarPorId(id);
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}
