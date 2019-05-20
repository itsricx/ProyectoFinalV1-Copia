package com.salesianostriana.dam.proyectofinalv1copia.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalv1copia.model.Usuario;
import com.salesianostriana.dam.proyectofinalv1copia.services.UsuarioServicio;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	UsuarioServicio usuarioServicio;

	public UserDetailsServiceImpl(UsuarioServicio servicio) {
		this.usuarioServicio = servicio;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioServicio.buscarPorEmail(username);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}

		return usuario;

	}
}
