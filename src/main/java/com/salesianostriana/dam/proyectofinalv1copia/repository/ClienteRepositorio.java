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
import com.salesianostriana.dam.proyectofinalv1copia.model.Cliente;

/**
 * @author rmejias
 *
 */
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

	public  List<Cliente> findByNombreContainingIgnoreCase(String nombre);
	

	public  Page<Cliente> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
	
}
