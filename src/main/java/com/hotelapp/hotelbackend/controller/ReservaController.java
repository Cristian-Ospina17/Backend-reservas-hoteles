package com.hotelapp.hotelbackend.controller;

import com.hotelapp.hotelbackend.model.Reserva;
import com.hotelapp.hotelbackend.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin("*")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    // 🔹 Crear
    @PostMapping
    public Reserva crear(@RequestBody Reserva reserva) {
        return service.crearReserva(reserva);
    }

    // 🔹 Listar
    @GetMapping
    public List<Reserva> listar() {
        return service.listar();
    }

    // 🔹 Buscar por ID
    @GetMapping("/{id}")
    public Reserva buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    // 🔹 Actualizar
    @PutMapping("/{id}")
    public Reserva actualizar(@PathVariable Long id, @RequestBody Reserva reserva) {
        return service.actualizar(id, reserva);
    }

    // 🔹 Cancelar reserva
    @PutMapping("/cancelar/{id}")
    public Reserva cancelar(@PathVariable Long id) {
        return service.cancelar(id);
    }

    // 🔹 Filtrar por estado
    @GetMapping("/filtrar/estado/{estado}")
    public List<Reserva> filtrarPorEstado(@PathVariable String estado) {
        return service.filtrarPorEstado(estado);
    }

    // 🔹 Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    // 🔥 Exportar CSV
    @GetMapping("/csv")
    public void exportarCSV(HttpServletResponse response) throws IOException {

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=reservas.csv");

        PrintWriter writer = response.getWriter();

        writer.println("ID,Usuario,Hotel,Entrada,Salida,Estado");

        for (Reserva r : service.listar()) {
            writer.println(
                    r.getId() + "," +
                            r.getNombreUsuario() + "," +
                            r.getHotel() + "," +
                            r.getFechaEntrada() + "," +
                            r.getFechaSalida() + "," +
                            r.getEstado()
            );
        }

        writer.flush();
        writer.close();
    }
}