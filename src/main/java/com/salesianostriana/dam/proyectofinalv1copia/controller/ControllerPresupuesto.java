package com.salesianostriana.dam.proyectofinalv1copia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.salesianostriana.dam.proyectofinalv1copia.services.LineaPresupuestoServicio;
import com.salesianostriana.dam.proyectofinalv1copia.services.PresupuestoServicio;



@Controller
@RequestMapping("/presupuesto/")
public class ControllerPresupuesto {

	@Autowired
	private PresupuestoServicio presupuestoServicio;
	
	@Autowired
	private LineaPresupuestoServicio lineaServicio;

	public ControllerPresupuesto(PresupuestoServicio presupuestoServicio, LineaPresupuestoServicio lineaServicio) {
		super();
		this.presupuestoServicio = presupuestoServicio;
		this.lineaServicio = lineaServicio;
	}
	
	@GetMapping ("/VerCarrito")
    public String verCarrito (Model model) {
    	
    	if (model.addAttribute("lineasPresupuestos", presupuestoServicio.getProductsInCart()) == null){
    	
    		return "html/ListadoProductosCliente";
    	}
    	return "html/carrito";
    }
	
	@GetMapping("/borrarLineaPresupuesto/{id}")
    public String borrarLineaPresupuesto(@PathVariable("id") Long id) {
        
		presupuestoServicio.removeLineaPresupuesto(lineaServicio.findById(id));
		
		return "html/carrito";
    }
	
	 @GetMapping ("/agregarLineaPresupuesto/{id}")
	    public String lineaACarrito (@PathVariable("id") Long id, Model model) {
	    	
		 	presupuestoServicio.addLineaPresupuesto(lineaServicio.findById(id));
		 
	    	    		 	
	    	return "html/carrito";
	    }
	
}
