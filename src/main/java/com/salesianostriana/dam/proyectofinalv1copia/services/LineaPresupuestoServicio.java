package com.salesianostriana.dam.proyectofinalv1copia.services;

import java.util.List;

import com.salesianostriana.dam.proyectofinalv1copia.model.LineaPresupuesto;
import com.salesianostriana.dam.proyectofinalv1copia.repository.LineaPresupuestoRepositorio;


public class LineaPresupuestoServicio {

private LineaPresupuestoRepositorio lineaPresupuestoRepositorio;

	

	public LineaPresupuesto add(LineaPresupuesto p) {
		
		return lineaPresupuestoRepositorio.save(p);
	}
	
	public LineaPresupuesto edit(LineaPresupuesto p) {
		return lineaPresupuestoRepositorio.save(p);
		
	}
	public void delete(LineaPresupuesto p) {
		lineaPresupuestoRepositorio.delete(p);
	}
	public void delete(Long id) {
		lineaPresupuestoRepositorio.deleteById(id);
	}
	public List<LineaPresupuesto> findAll(){
		return lineaPresupuestoRepositorio.findAll();
	}
	public LineaPresupuesto findById(Long id) {
		return lineaPresupuestoRepositorio.findById(id).orElse(null);
	}
}
