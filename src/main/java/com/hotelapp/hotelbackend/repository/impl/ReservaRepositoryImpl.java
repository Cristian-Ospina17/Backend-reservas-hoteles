package com.hotelapp.hotelbackend.repository.impl;

import com.hotelapp.hotelbackend.model.Reserva;
import com.hotelapp.hotelbackend.repository.ReservaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ReservaRepositoryImpl implements ReservaRepository {

    private final Map<Long, Reserva> reservas = new HashMap<>();
    private Long contadorId = 1L;

    @Override
    public Reserva guardar(Reserva reserva) {
        if (reserva.getId() == null) {
            reserva.setId(contadorId++);
        }
        reservas.put(reserva.getId(), reserva);
        return reserva;
    }

    @Override
    public List<Reserva> listar() {
        return new ArrayList<>(reservas.values());
    }

    @Override
    public Reserva buscarPorId(Long id) {
        return reservas.get(id);
    }

    @Override
    public Reserva actualizar(Long id, Reserva reserva) {
        if (!reservas.containsKey(id)) {
            throw new RuntimeException("Reserva no encontrada");
        }
        reserva.setId(id);
        reservas.put(id, reserva);
        return reserva;
    }

    @Override
    public List<Reserva> filtrarPorEstado(String estado) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas.values()) {
            if (r.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    @Override
    public void cambiarEstado(Long id, String estado) {
        Reserva r = reservas.get(id);
        if (r == null) {
            throw new RuntimeException("Reserva no encontrada");
        }
        r.setEstado(estado);
    }

    @Override
    public void eliminar(Long id) {
        reservas.remove(id);
    }
}