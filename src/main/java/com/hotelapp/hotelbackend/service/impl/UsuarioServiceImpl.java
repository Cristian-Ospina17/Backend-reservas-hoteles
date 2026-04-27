package com.hotelapp.hotelbackend.service.impl;

import com.hotelapp.hotelbackend.model.Usuario;
import com.hotelapp.hotelbackend.repository.UsuarioRepository;
import com.hotelapp.hotelbackend.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {

        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            throw new RuntimeException("Nombre requerido");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new RuntimeException("Email requerido");
        }

        return repository.guardar(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return repository.listar();
    }

    @Override
    public Usuario buscar(Long id) {
        Usuario usuario = repository.buscarPorId(id);

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        return usuario;
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        return repository.actualizar(id, usuario);
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}
