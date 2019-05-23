package com.salesianostriana.dam.proyectofinalv1copia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.salesianostriana.dam.proyectofinalv1copia.model.Pager;
import com.salesianostriana.dam.proyectofinalv1copia.model.Producto;
import com.salesianostriana.dam.proyectofinalv1copia.services.ProductoServicio;

@Controller
@RequestMapping("/producto/")
public class ControllerProducto {

	private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
	
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
	@GetMapping("verListadoProductos")
    public String showClientsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page, Model model) {

		// Evalúa el tamaño de página. Si el parámetro es "nulo", devuelve
    	// el tamaño de página inicial.
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        
        // Calcula qué página se va a mostrar. Si el parámetro es "nulo" o menor
        // que 0, se devuelve el valor inicial. De otro modo, se devuelve el valor
        // del parámetro decrementado en 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        // Obtenemos la página definida por evalPage y evalPageSize de objetos de nuestro modelo
        Page<Producto> products = productoServicio.findAllPageable(PageRequest.of(evalPage, evalPageSize));
        // Creamos el objeto Pager (paginador) indicando los valores correspondientes.
        // Este sirve para que la plantilla sepa cuantas páginas hay en total, cuantos botones
        // debe mostrar y cuál es el número de objetos a dibujar.
        Pager pager = new Pager(products.getTotalPages(), products.getNumber(), BUTTONS_TO_SHOW);
        
        model.addAttribute("products", products);
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("pager", pager);
    	
    	return "html/ListadoProducto";
    }
			
			
			//METODO LISTAR TODOS LOS PRODUCTOS CLIENTE
			@GetMapping("listadoProductoCliente")
			public String mostrarTodosProductosCliente(Model model) {
				model.addAttribute("lista", productoServicio.findAll());
				return "html/ListadoProductosCliente";
			}
			
			// METODO MOSTRAR FORMULARIO REGISTRO_DE_PRODUCTO ADMIN
			@GetMapping("nuevo/producto")
			public String mostrarFormularioRegistroProducto(Model model) {
				model.addAttribute("producto", new Producto());
				return "html/RegistroProducto";
			}

			
			// METODO RESPUESTA FORMULARIO REGISTRO_DE_PRODUCTO ADMIN
			@PostMapping("nuevo/producto/submit")
			public String procesarFormularioRegistroProducto(@ModelAttribute("producto") Producto p) {
				productoServicio.save(p);
				return "redirect:/producto/verListadoProductos";
			}
			
			// METODO LISTAR PRODUCTOS POR NOMBRE
			
			// METODO BORRAR UN PRODUCTO ADMIN
			@GetMapping("/borrar/producto/{id}")
			public String borrarProducto(@PathVariable("id") long id) {
				productoServicio.deleteById(id);
				return "redirect:/producto/verListadoProductos";
			}
			
			// METODO EDITAR UN PRODUCTO ADMIN
			@GetMapping("editarProducto/{id}") 
			public String mostrarFormularioEditarProducto(@PathVariable("id") long id, Model model) {
				Producto pEditar = productoServicio.findById(id);

				if (pEditar != null) {
					model.addAttribute("producto", pEditar);
				} else {
					return "redirect:/producto/verListadoProductos";

				}

				return "html/RegistroProducto";
			}
			
			// METODO EDITAR UN PRODUCTO(RESPUESTA) ADMIN
			@PostMapping("editarProducto/submit")
			public String procesarFormularioEditarProducto(@ModelAttribute("producto") Producto p) {
				
				productoServicio.edit(p);
				
				return "redirect:/producto/verListadoProductos";
				
			}
	
}
