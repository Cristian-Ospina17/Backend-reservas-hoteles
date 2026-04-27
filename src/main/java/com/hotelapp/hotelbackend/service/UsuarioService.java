package com.hotelapp.hotelbackend.service;

import com.hotelapp.hotelbackend.model.Usuario;
import java.util.List;

public interface UsuarioService {

    Usuario crearUsuario(Usuario usuario);

    List<Usuario> listar();

    Usuario buscar(Long id);

    Usuario actualizar(Long id, Usuario usuario);

    void eliminar(Long id);
}