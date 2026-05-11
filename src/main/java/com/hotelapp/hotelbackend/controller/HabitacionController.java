package com.hotelapp.hotelbackend.controller;

import com.hotelapp.hotelbackend.model.Habitacion;
import com.hotelapp.hotelbackend.service.HabitacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
@CrossOrigin("*")
public class HabitacionController {

    private final HabitacionService service;

    public HabitacionController(HabitacionService service) {
        this.service = service;
    }

    @PostMapping
    public Habitacion crear(@RequestBody Habitacion habitacion) {
        return service.crearHabitacion(habitacion);
    }

    @GetMapping
    public List<Habitacion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Habitacion buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @GetMapping("/hotel/{hotelId}")
    public List<Habitacion> listarPorHotel(@PathVariable Long hotelId) {
        return service.listarPorHotel(hotelId);
    }

    @GetMapping("/hotel/{hotelId}/disponibles")
    public List<Habitacion> listarDisponiblesPorHotel(@PathVariable Long hotelId) {
        return service.listarDisponiblesPorHotel(hotelId);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}