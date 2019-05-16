/**
 * 
 */
package com.salesianostriana.dam.proyectofinalv1copia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinalv1copia.model.Cliente;

/**
 * @author rmejias
 *
 */
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
