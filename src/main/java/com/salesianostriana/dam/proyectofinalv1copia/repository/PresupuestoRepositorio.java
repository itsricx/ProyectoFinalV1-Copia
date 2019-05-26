package com.salesianostriana.dam.proyectofinalv1copia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinalv1copia.model.Presupuesto;
/**
 * Repositorio del presupuesto
 * @author rmejias
 *@version 1.0
 */
@Repository
public interface PresupuestoRepositorio extends JpaRepository<Presupuesto, Long> {

}
