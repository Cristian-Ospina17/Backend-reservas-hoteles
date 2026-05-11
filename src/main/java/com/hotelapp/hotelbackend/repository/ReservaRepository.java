package com.hotelapp.hotelbackend.repository;

import com.hotelapp.hotelbackend.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByEstadoIgnoreCase(String estado);

    List<Reserva> findByHotelIgnoreCaseAndEstadoIgnoreCase(
            String hotel,
            String estado
    );
}