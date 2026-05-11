package com.hotelapp.hotelbackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreUsuario;
    private String hotel;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estado;

    public Reserva() {}

    public Reserva(Long id, String nombreUsuario, String hotel,
                   LocalDate fechaEntrada, LocalDate fechaSalida, String estado) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.hotel = hotel;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getHotel() { return hotel; }
    public LocalDate getFechaEntrada() { return fechaEntrada; }
    public LocalDate getFechaSalida() { return fechaSalida; }
    public String getEstado() { return estado; }

    public void setId(Long id) { this.id = id; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public void setHotel(String hotel) { this.hotel = hotel; }
    public void setFechaEntrada(LocalDate fechaEntrada) { this.fechaEntrada = fechaEntrada; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }
    public void setEstado(String estado) { this.estado = estado; }
}