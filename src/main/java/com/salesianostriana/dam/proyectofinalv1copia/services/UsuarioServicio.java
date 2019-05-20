package com.salesianostriana.dam.proyectofinalv1copia.services;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalv1copia.model.Usuario;
import com.salesianostriana.dam.proyectofinalv1copia.repository.UsuarioRepositorio;

@Service
public class UsuarioServicio extends BaseService<Usuario, Long, UsuarioRepositorio> {

	public Usuario buscarPorEmail(String email) {
		return repositorio.findFirstByEmail(email);
	}

}
