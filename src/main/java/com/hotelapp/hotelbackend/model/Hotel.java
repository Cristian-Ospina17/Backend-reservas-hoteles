package com.hotelapp.hotelbackend.model;

import java.util.List;

public class Hotel {

    private Long id;
    private String nombre;
    private String ciudad;
    private double precioPorNoche;
    private String categoria;
    private List<String> caracteristicas;

    public Hotel() {
    }

    public Hotel(Long id, String nombre, String ciudad, double precioPorNoche,
                 String categoria, List<String> caracteristicas) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.precioPorNoche = precioPorNoche;
        this.categoria = categoria;
        this.caracteristicas = caracteristicas;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public String getCategoria() {
        return categoria;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}