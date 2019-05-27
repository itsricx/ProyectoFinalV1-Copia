package com.salesianostriana.dam.proyectofinalv1copia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.salesianostriana.dam.proyectofinalv1copia.services.PresupuestoServicio;
import com.salesianostriana.dam.proyectofinalv1copia.services.ProductoServicio;

/**
 * Esta clase es la encargada de manejar las peticiones relacionadas con el
 * presupuesto
 * 
 * @author Rick
 * @version 1.0
 */
@Controller
@RequestMapping("/presupuesto/")
public class ControllerPresupuesto {

	@Autowired
	private PresupuestoServicio presupuestoServicio;

	@Autowired
	private ProductoServicio ps;

	/**
	 * Constructor completo
	 * 
	 * @param presupuestoServicio Instancia de presupuesto Servicio
	 */
	public ControllerPresupuesto(PresupuestoServicio presupuestoServicio) {
		super();
		this.presupuestoServicio = presupuestoServicio;
	}

	/**
	 * Metodo que muestra el carrito
	 * 
	 * return El carrito actual
	 */
	@GetMapping("VerCarrito")
	public String verCarrito(Model model) {

		model.addAttribute("listado", presupuestoServicio.getLineasPresupuestos());

		return "html/Carrito";
	}

	/**
	 * Metodo que borra una lina de presupuesto
	 * 
	 * return El carrito actual
	 */
	@GetMapping("borrarLineaPresupuesto/{id}")
	public String borrarLineaPresupuesto(@PathVariable("id") Long id) {

		presupuestoServicio.borrarProducto(ps.findById(id));

		return "redirect:/presupuesto/VerCarrito";
	}

	/**
	 * Metodo que agrega una lina de presupuesto
	 * 
	 * return El carrito actual
	 */
	@GetMapping("agregarLineaPresupuesto/{id}")
	public String lineaACarrito(@PathVariable("id") Long id, Model model) {
		presupuestoServicio.agregarProducto(ps.findById(id));

		return "redirect:/presupuesto/VerCarrito";
	}

	/**
	 * Metodo que calcula el total de los productos en el carrito
	 * 
	 * return El total del carrito actual
	 */
	@ModelAttribute("totalCarrito")
	public Double calcularTotal() {
		
		return presupuestoServicio.calcularTotal();
		
	}

}
