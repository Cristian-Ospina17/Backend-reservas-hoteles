package com.hotelapp.hotelbackend.controller;

import com.hotelapp.hotelbackend.model.Hotel;
import com.hotelapp.hotelbackend.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
@CrossOrigin("*")
public class HotelController {

    private final HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }

    // 🔹 Crear hotel
    @PostMapping
    public Hotel crear(@RequestBody Hotel hotel) {
        return service.crearHotel(hotel);
    }

    // 🔹 Listar hoteles
    @GetMapping
    public List<Hotel> listar() {
        return service.listar();
    }

    // 🔹 Buscar hotel por ID
    @GetMapping("/{id}")
    public Hotel buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    // 🔹 Actualizar hotel
    @PutMapping("/{id}")
    public Hotel actualizar(@PathVariable Long id, @RequestBody Hotel hotel) {
        return service.actualizar(id, hotel);
    }

    // 🔹 Filtrar por ciudad
    @GetMapping("/filtrar/ciudad/{ciudad}")
    public List<Hotel> filtrarPorCiudad(@PathVariable String ciudad) {
        return service.filtrarPorCiudad(ciudad);
    }

    // 🔥 Disponibilidad MOCK (HU23)
    @GetMapping("/{id}/disponibilidad")
    public String disponibilidad(@PathVariable Long id) {
        Hotel hotel = service.buscar(id);
        return "El hotel " + hotel.getNombre() + " tiene disponibilidad mock.";
    }

    // 🔹 Eliminar hotel
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}