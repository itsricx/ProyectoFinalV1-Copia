/**
 * 
 */
package com.salesianostriana.dam.proyectofinalv1copia.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinalv1copia.model.Administrador;

/**
 * Repositorio de los administradores, incluye dos metodos
 * @author rmejias
 *@version 1.0
 */
@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {

	/**
	 * Se encarga de buscar  a los administradores por su nombre
	 * @param nombre
	 * return Una lista de administradores
	 * */
public  List<Administrador> findByNombreContainingIgnoreCase(String nombre);
	
/**
 * Se encarga de buscar  a los administradores por su nombre, paginados
 * @param nombre
 * @param pageable
 * return Un paginado de administradores
 * */
	public  Page<Administrador> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
	
}
