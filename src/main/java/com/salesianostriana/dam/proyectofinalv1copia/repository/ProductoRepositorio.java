/**
 * 
 */
package com.salesianostriana.dam.proyectofinalv1copia.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinalv1copia.model.Producto;

/**
 * @author rmejias
 *
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{

	public  List<Producto> findByNombreContainingIgnoreCase(String nombre);
	

	public  Page<Producto> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
	
}
