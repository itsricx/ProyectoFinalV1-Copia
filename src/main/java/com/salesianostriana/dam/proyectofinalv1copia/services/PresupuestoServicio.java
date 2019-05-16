package com.salesianostriana.dam.proyectofinalv1copia.services;

import java.util.List;

import com.salesianostriana.dam.proyectofinalv1copia.model.Presupuesto;
import com.salesianostriana.dam.proyectofinalv1copia.repository.PresupuestoRepositorio;

public class PresupuestoServicio {

	private PresupuestoRepositorio presupuestoRepositorio;

	
	//AÑADIR
	public Presupuesto add(Presupuesto p) {
		
		return presupuestoRepositorio.save(p);
	}
	//EDITAR
	public Presupuesto edit(Presupuesto p) {
		return presupuestoRepositorio.save(p);
		
	}
	//BORRAR PRESUPUESTO
	public void delete(Presupuesto p) {
		presupuestoRepositorio.delete(p);
	}
	//BORRAR POR ID
	public void delete(Long id) {
		presupuestoRepositorio.deleteById(id);
	}
	//LISTADO DE PRESUPUESTOS
	public List<Presupuesto> findAll(){
		return presupuestoRepositorio.findAll();
	}
	//BUSCAR POR ID
	public Presupuesto findById(Long id) {
		return presupuestoRepositorio.findById(id).orElse(null);
	}
	//BUSCAR POR NOMBRE
//	public findByName(String name) {
//		
//	}
	//TOTAL DEL PRESUPUESTO
//	public Double calcularTotal() {}
}
