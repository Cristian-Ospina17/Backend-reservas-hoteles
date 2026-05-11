package com.hotelapp.hotelbackend.service;

import com.hotelapp.hotelbackend.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listar();

    Optional<Usuario> buscarPorId(Long id);

    Usuario guardar(Usuario usuario);

    Usuario actualizar(Long id, Usuario usuario);

    void eliminar(Long id);

    Optional<Usuario> buscarPorEmail(String email);
}