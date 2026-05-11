package com.hotelapp.hotelbackend.model;

public class Habitacion {

    private Long id;
    private Long hotelId;
    private int numero;
    private String categoria;
    private double precio;
    private boolean disponible;

    public Habitacion() {}

    public Habitacion(Long id, Long hotelId, int numero, String categoria, double precio, boolean disponible) {
        this.id = id;
        this.hotelId = hotelId;
        this.numero = numero;
        this.categoria = categoria;
        this.precio = precio;
        this.disponible = disponible;
    }

    public Long getId() { return id; }
    public Long getHotelId() { return hotelId; }
    public int getNumero() { return numero; }
    public String getCategoria() { return categoria; }
    public double getPrecio() { return precio; }
    public boolean isDisponible() { return disponible; }

    public void setId(Long id) { this.id = id; }
    public void setHotelId(Long hotelId) { this.hotelId = hotelId; }
    public void setNumero(int numero) { this.numero = numero; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
