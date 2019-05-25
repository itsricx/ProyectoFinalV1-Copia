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
 * @author rmejias
 *
 */
@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {

public  List<Administrador> findByNombreContainingIgnoreCase(String nombre);
	

	public  Page<Administrador> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
	
}
