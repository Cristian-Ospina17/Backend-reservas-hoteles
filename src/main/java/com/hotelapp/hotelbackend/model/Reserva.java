package com.hotelapp.hotelbackend.model;

import java.time.LocalDate;

public class Reserva {

    private Long id;
    private String nombreUsuario;
    private String hotel;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estado; // ACTIVA o CANCELADA

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
    public void setId(Long id) { this.id = id; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getHotel() { return hotel; }
    public void setHotel(String hotel) { this.hotel = hotel; }

    public LocalDate getFechaEntrada() { return fechaEntrada; }
    public void setFechaEntrada(LocalDate fechaEntrada) { this.fechaEntrada = fechaEntrada; }

    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", hotel='" + hotel + '\'' +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", estado='" + estado + '\'' +
                '}';
    }
}