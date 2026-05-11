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

        List<Reserva> reservasActivasDelHotel =
                repository.findByHotelIgnoreCaseAndEstadoIgnoreCase(
                        reserva.getHotel(),
                        "ACTIVA"
                );

        for (Reserva existente : reservasActivasDelHotel) {

            boolean fechasSeCruzan =
                    reserva.getFechaEntrada().isBefore(existente.getFechaSalida())
                            &&
                            reserva.getFechaSalida().isAfter(existente.getFechaEntrada());

            if (fechasSeCruzan) {
                throw new RuntimeException(
                        "El hotel no está disponible en esas fechas"
                );
            }
        }

        Reserva nueva = ReservaFactory.crear(
                reserva.getNombreUsuario(),
                reserva.getHotel(),
                reserva.getFechaEntrada(),
                reserva.getFechaSalida()
        );

        return repository.save(nueva);
    }

    @Override
    public List<Reserva> listar() {
        return repository.findAll();
    }

    @Override
    public Reserva buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    public Reserva actualizar(Long id, Reserva nueva) {
        Reserva existente = buscar(id);

        existente.setNombreUsuario(nueva.getNombreUsuario());
        existente.setHotel(nueva.getHotel());
        existente.setFechaEntrada(nueva.getFechaEntrada());
        existente.setFechaSalida(nueva.getFechaSalida());

        return repository.save(existente);
    }

    @Override
    public List<Reserva> filtrarPorEstado(String estado) {
        return repository.findByEstadoIgnoreCase(estado);
    }

    @Override
    public Reserva cancelar(Long id) {
        Reserva reserva = buscar(id);
        reserva.setEstado("CANCELADA");
        return repository.save(reserva);
    }

    @Override
    public void eliminar(Long id) {
        Reserva reserva = buscar(id);
        repository.delete(reserva);
    }
}