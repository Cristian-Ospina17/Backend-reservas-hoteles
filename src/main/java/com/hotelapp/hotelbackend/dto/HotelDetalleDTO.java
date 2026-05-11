// HotelDetalleDTO.java
package com.hotelapp.hotelbackend.dto;

import com.hotelapp.hotelbackend.model.Habitacion;

import java.util.List;

public class HotelDetalleDTO {

    private Long id;
    private String nombre;
    private String ciudad;
    private double precioPorNoche;
    private String categoria;

    private String imagen;
    private String descripcion;

    private List<String> caracteristicas;

    private Integer cantidadHabitaciones;
    private Integer banos;
    private Integer personasMax;

    private List<Habitacion> habitaciones;

    public HotelDetalleDTO() {
    }

    public HotelDetalleDTO(
            Long id,
            String nombre,
            String ciudad,
            double precioPorNoche,
            String categoria,
            String imagen,
            String descripcion,
            List<String> caracteristicas,
            Integer cantidadHabitaciones,
            Integer banos,
            Integer personasMax,
            List<Habitacion> habitaciones
    ) {

        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.precioPorNoche = precioPorNoche;
        this.categoria = categoria;

        this.imagen = imagen;
        this.descripcion = descripcion;

        this.caracteristicas = caracteristicas;

        this.cantidadHabitaciones = cantidadHabitaciones;
        this.banos = banos;
        this.personasMax = personasMax;

        this.habitaciones = habitaciones;
    }

    // GETTERS

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

    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public Integer getBanos() {
        return banos;
    }

    public Integer getPersonasMax() {
        return personasMax;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    // SETTERS

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

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public void setBanos(Integer banos) {
        this.banos = banos;
    }

    public void setPersonasMax(Integer personasMax) {
        this.personasMax = personasMax;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}