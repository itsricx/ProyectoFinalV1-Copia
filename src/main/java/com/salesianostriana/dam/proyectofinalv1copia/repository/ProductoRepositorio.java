/**
 * 
 */
package com.salesianostriana.dam.proyectofinalv1copia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinalv1copia.model.Producto;

/**
 * @author rmejias
 *
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{

}
