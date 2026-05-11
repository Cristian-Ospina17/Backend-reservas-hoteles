package com.hotelapp.hotelbackend.controller;

import com.hotelapp.hotelbackend.dto.HotelDetalleDTO;
import com.hotelapp.hotelbackend.model.Habitacion;
import com.hotelapp.hotelbackend.model.Hotel;
import com.hotelapp.hotelbackend.service.HabitacionService;
import com.hotelapp.hotelbackend.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
@CrossOrigin("*")
public class HotelController {

    private final HotelService service;
    private final HabitacionService habitacionService;

    public HotelController(HotelService service, HabitacionService habitacionService) {
        this.service = service;
        this.habitacionService = habitacionService;
    }

    @PostMapping
    public Hotel crear(@RequestBody Hotel hotel) {
        return service.crearHotel(hotel);
    }

    @GetMapping
    public List<Hotel> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public HotelDetalleDTO buscar(@PathVariable Long id) {
        Hotel hotel = service.buscar(id);

        List<Habitacion> habitaciones =
                habitacionService.listarPorHotel(id);

        return new HotelDetalleDTO(
                hotel.getId(),
                hotel.getNombre(),
                hotel.getCiudad(),
                hotel.getPrecioPorNoche(),
                hotel.getCategoria(),
                hotel.getImagen(),
                hotel.getDescripcion(),
                hotel.getCaracteristicas(),
                hotel.getCantidadHabitaciones(),
                hotel.getBanos(),
                hotel.getPersonasMax(),
                habitaciones
        );
    }

    @PutMapping("/{id}")
    public Hotel actualizar(@PathVariable Long id, @RequestBody Hotel hotel) {
        return service.actualizar(id, hotel);
    }

    @GetMapping("/filtrar/ciudad/{ciudad}")
    public List<Hotel> filtrarPorCiudad(@PathVariable String ciudad) {
        return service.filtrarPorCiudad(ciudad);
    }

    @GetMapping("/{id}/disponibilidad")
    public String disponibilidad(@PathVariable Long id) {
        Hotel hotel = service.buscar(id);

        List<Habitacion> habitaciones =
                habitacionService.listarDisponiblesPorHotel(id);

        return "El hotel "
                + hotel.getNombre()
                + " tiene "
                + habitaciones.size()
                + " habitaciones disponibles.";
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}