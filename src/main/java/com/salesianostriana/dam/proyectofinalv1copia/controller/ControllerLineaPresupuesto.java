package com.salesianostriana.dam.proyectofinalv1copia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinalv1copia.services.LineaPresupuestoServicio;

@Controller
@RequestMapping("/lineaPresupuesto/")
public class ControllerLineaPresupuesto {

	private LineaPresupuestoServicio lineaServicio;

	public ControllerLineaPresupuesto(LineaPresupuestoServicio lineaServicio) {
		super();
		this.lineaServicio = lineaServicio;
	}
	
	
}
