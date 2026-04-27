package com.hotelapp.hotelbackend.repository.impl;

import com.hotelapp.hotelbackend.model.Usuario;
import com.hotelapp.hotelbackend.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final Map<Long, Usuario> usuarios = new HashMap<>();
    private Long contadorId = 1L;

    @Override
    public Usuario guardar(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario.setId(contadorId++);
        }

        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        return new ArrayList<>(usuarios.values());
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarios.get(id);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        if (!usuarios.containsKey(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }

        usuario.setId(id);
        usuarios.put(id, usuario);
        return usuario;
    }

    @Override
    public void eliminar(Long id) {
        if (!usuarios.containsKey(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }

        usuarios.remove(id);
    }
}