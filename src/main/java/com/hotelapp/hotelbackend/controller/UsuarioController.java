package com.hotelapp.hotelbackend.controller;

import com.hotelapp.hotelbackend.model.Usuario;
import com.hotelapp.hotelbackend.security.JwtUtil;
import com.hotelapp.hotelbackend.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService service;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UsuarioController(UsuarioService service,
                             PasswordEncoder passwordEncoder,
                             JwtUtil jwtUtil) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // Crear usuario
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    // Login con BCrypt + JWT
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Usuario usuario) {
        Usuario usuarioEncontrado = service.buscarPorEmail(usuario.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));

        boolean passwordCorrecta = passwordEncoder.matches(
                usuario.getPassword(),
                usuarioEncontrado.getPassword()
        );

        if (!passwordCorrecta) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        String token = jwtUtil.generarToken(usuarioEncontrado.getEmail());

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("token", token);
        respuesta.put("usuario", usuarioEncontrado);

        return respuesta;
    }

    // Listar usuarios
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    // Buscar usuario por id
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id,
                              @RequestBody Usuario usuario) {
        return service.actualizar(id, usuario);
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}