package com.hotelapp.hotelbackend.config;

public class Configuracion {

    private static Configuracion instancia;

    private String nombreSistema = "HotelApp";
    private String version = "1.0";

    private Configuracion() {}

    public static Configuracion getInstancia() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }

    public String getNombreSistema() {
        return nombreSistema;
    }

    public String getVersion() {
        return version;
    }
}