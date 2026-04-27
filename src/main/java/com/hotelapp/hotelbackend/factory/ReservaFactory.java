package com.hotelapp.hotelbackend.factory;

import com.hotelapp.hotelbackend.model.Reserva;
import java.time.LocalDate;

public class ReservaFactory {

    public static Reserva crear(String usuario, String hotel,
                                LocalDate entrada, LocalDate salida) {

        return new Reserva(
                null,
                usuario,
                hotel,
                entrada,
                salida,
                "ACTIVA" // 🔥 estado inicial obligatorio
        );
    }
}