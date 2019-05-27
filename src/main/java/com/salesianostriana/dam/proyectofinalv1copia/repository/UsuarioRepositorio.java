package com.salesianostriana.dam.proyectofinalv1copia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalv1copia.model.Usuario;
/**
 * Repositorio de la clase abstracta usuario
 * @author rmejias
 *@version 1.0
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	/**
	 * Encuentra a los usuarios por su email
	 * @param email el email
	 * return El usuario encontrado
	 */
	Usuario findFirstByEmail(String email);
	
	
}
