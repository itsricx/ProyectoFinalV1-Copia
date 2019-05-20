package com.salesianostriana.dam.proyectofinalv1copia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinalv1copia.model.Producto;
import com.salesianostriana.dam.proyectofinalv1copia.services.ProductoServicio;

@Controller
@RequestMapping("/producto/")
public class ControllerProducto {

	@Autowired
	private ProductoServicio productoServicio;
	
	
	
			/**
	 * @param productoServicio
	 */
	public ControllerProducto(ProductoServicio productoServicio) {
		super();
		this.productoServicio = productoServicio;
	}

			//METODO LISTAR TODOS LOS PRODUCTOS ADMIN
			@GetMapping("/listadoProductoAdmin")
			public String mostrarTodosProductosAdmin(Model model) {
				model.addAttribute("lista", productoServicio.findAll());
				return "html/plantillaListadoProducto";
			}
			
//			@GetMapping("/")
//			public String index() {
//				
//				return "html/Index";
//				
//			}
			
			
			//METODO LISTAR TODOS LOS PRODUCTOS CLIENTE
			@GetMapping("/listadoProductoCliente")
			public String mostrarTodosProductosCliente(Model model) {
				model.addAttribute("lista", productoServicio.findAll());
				return "html/plantillaListadoProductoCliente";
			}
			
			// METODO MOSTRAR FORMULARIO REGISTRO_DE_PRODUCTO ADMIN
			@GetMapping("nuevo/producto")
			public String mostrarFormularioRegistroProducto(Model model) {
				model.addAttribute("producto", new Producto());
				return "html/plantillaFormularioRegistroProducto";
			}

			
			// METODO RESPUESTA FORMULARIO REGISTRO_DE_PRODUCTO ADMIN
			@PostMapping("nuevo/producto/submit")
			public String procesarFormularioRegistroProducto(@ModelAttribute("producto") Producto p) {
				productoServicio.save(p);
				return "html/plantillaListadoProducto";
			}
			
			// METODO LISTAR PRODUCTOS POR NOMBRE
			
			// METODO BORRAR UN PRODUCTO ADMIN
			@GetMapping("/borrar/producto/{id}")
			public String borrarProducto(@PathVariable("id") long id) {
				productoServicio.deleteById(id);
				return "html/plantillaListadoProducto";
			}
			
			// METODO EDITAR UN PRODUCTO ADMIN
			@GetMapping("editarProducto/{id}") 
			public String mostrarFormularioEditarProducto(@PathVariable("id") long id, Model model) {
				Producto pEditar = productoServicio.findById(id);

				if (pEditar != null) {
					model.addAttribute("producto", pEditar);
				} else {
					return "html/plantillaListadoProducto";

				}

				return "html/plantillaFormularioRegistroProducto";
			}
			
			// METODO EDITAR UN PRODUCTO(RESPUESTA) ADMIN
			@PostMapping("editarProducto/submit")
			public String procesarFormularioEditarProducto(@ModelAttribute("producto") Producto p) {
				
				productoServicio.edit(p);
				
				return "html/plantillaListadoProducto";
				
			}
	
}
