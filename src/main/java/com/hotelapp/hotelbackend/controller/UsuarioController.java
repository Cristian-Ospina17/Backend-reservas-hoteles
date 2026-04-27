package com.hotelapp.hotelbackend.controller;

import com.hotelapp.hotelbackend.model.Usuario;
import com.hotelapp.hotelbackend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // 🔹 Crear usuario
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.crearUsuario(usuario);
    }

    // 🔹 Login
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        return service.listar()
                .stream()
                .filter(u -> u.getEmail().equals(usuario.getEmail())
                        && u.getPassword().equals(usuario.getPassword()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));
    }

    // 🔹 Listar usuarios
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    // 🔹 Buscar usuario
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    // 🔹 Actualizar usuario
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.actualizar(id, usuario);
    }

    // 🔹 Eliminar usuario
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}