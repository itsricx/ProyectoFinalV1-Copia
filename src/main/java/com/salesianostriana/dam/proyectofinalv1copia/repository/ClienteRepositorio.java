/**
 * 
 */
package com.salesianostriana.dam.proyectofinalv1copia.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinalv1copia.model.Cliente;

/**
 * Repositorio de los clientes, incluye dos metodos
 * @author rmejias
 *@version 1.0
 */
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

	/**
	 * Se encarga de buscar  a los clientes por su nombre
	 * @param nombre
	 * return Una lista de clientes
	 * */
	public  List<Cliente> findByNombreContainingIgnoreCase(String nombre);
	
	/**
	 * Se encarga de buscar  a los clientes por su nombre, paginados
	 * @param nombre
	 * @param pageable
	 * return Un paginado de clientes
	 * */
	public  Page<Cliente> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
	
	
	
}
