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
 * Repositorio de los productos, incluye dos metodos
 * @author rmejias
 *@version 1.0
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{

	/**
	 * Se encarga de buscar  a los productos por su nombre
	 * @param nombre
	 * return Una lista de productos
	 * */
	public  List<Producto> findByNombreContainingIgnoreCase(String nombre);
	
	/**
	 * Se encarga de buscar  a los productos por su nombre, paginados
	 * @param nombre
	 * @param pageable
	 * return Un paginado de productos
	 * */
	public  Page<Producto> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
		
	public Page<Producto> findByPrecioLessThan(Double precio, Pageable pageable);

	
}
