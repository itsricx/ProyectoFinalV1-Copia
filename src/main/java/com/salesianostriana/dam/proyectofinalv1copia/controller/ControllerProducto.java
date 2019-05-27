package com.salesianostriana.dam.proyectofinalv1copia.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

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
/**
* Esta clase es la encargada de manejar las peticiones relacionadas con los productos
* @author Rick
* @version 1.0
* */
@Controller
@RequestMapping("/producto/")
public class ControllerProducto {

	private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
	
	@Autowired
	private ProductoServicio productoServicio;
	
	@Autowired
	HttpSession session;
	
	
	
	

	/**Constructor de Controller Producto
	 * @param productoServicio Instancia de producto Servicio
	 */
	public ControllerProducto(ProductoServicio productoServicio) {
		super();
		this.productoServicio = productoServicio;
	}

	/**
	 * Metodo que muestra el listado de productos paginado al admin
	 * 
	 * @param model Modelo
	 * @param pageSize tamanyo de pagina
	 * @param page page
	 * @param nombre   Nombre return El listado de productos paginado
	 */
	//METODO LISTAR TODOS LOS PRODUCTOS ADMIN
	@GetMapping("verListadoProductos")
	public String showProductsPageAdmin(@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page, @RequestParam("nombre") Optional<String> nombre, Model model) {

    	
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        
       
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        
        String evalNombre = nombre.orElse(null);
        
        Page<Producto> products = null;
        
        if (evalNombre == null) {
        	products = productoServicio.findAllPageable(PageRequest.of(evalPage, evalPageSize));
        } else {
        	products = productoServicio.findByNombreContainingIgnoreCasePageable(evalNombre, PageRequest.of(evalPage, evalPageSize));
        }

       
        Pager pager = new Pager(products.getTotalPages(), products.getNumber(), BUTTONS_TO_SHOW);
        
        model.addAttribute("products", products);
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("pager", pager);
    	
    	return "html/ListadoProducto";
    }
			

	/**
	 * Metodo que muestra el listado de productos paginado al cliente
	 * 
	 * @param model Modelo
	 * @param pageSize tamanyo de Pagina
	 * @param page Pagina
	 * @param nombre   Nombre return El listado de productos paginado
	 */
			//METODO LISTAR TODOS LOS PRODUCTOS CLIENTE
	@GetMapping("buscarProductos")
	public String showProductsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page, @RequestParam("nombre") Optional<String> nombre, Model model) {

    	
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
      
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        
        String evalNombre = nombre.orElse(null);
        
        Page<Producto> products = null;
        
        if (evalNombre == null) {
        	products = productoServicio.findAllPageable(PageRequest.of(evalPage, evalPageSize));
        } else {
        	products = productoServicio.findByNombreContainingIgnoreCasePageable(evalNombre, PageRequest.of(evalPage, evalPageSize));
        }

      
        Pager pager = new Pager(products.getTotalPages(), products.getNumber(), BUTTONS_TO_SHOW);
        
        model.addAttribute("products", products);
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("pager", pager);
        
    	return "html/ListadoProductosCliente";
    }
	/**
	 * Metodo que muestra el formulario de registro de un  producto para un admin
	 * 
	 * @param model Modelo
	 * return El formulario de registro de un producto
	 */
			// METODO MOSTRAR FORMULARIO REGISTRO_DE_PRODUCTO ADMIN
			@GetMapping("nuevo/producto")
			public String mostrarFormularioRegistroProducto(Model model) {
				model.addAttribute("producto", new Producto());
				return "html/RegistroProducto";
			}

			/**
			 * Metodo que procesa la informacion del formulario de registro para un cliente
			 * 
			 * @param p producto
			 * return login
			 */
			// METODO RESPUESTA FORMULARIO REGISTRO_DE_PRODUCTO ADMIN
			@PostMapping("nuevo/producto/submit")
			public String procesarFormularioRegistroProducto(@ModelAttribute("producto") Producto p) {
				productoServicio.save(p);
				return "redirect:/producto/verListadoProductos";
			}
			
			/**
			 * Metodo que borra un producto, esto lo hace un admin
			 * 
			 * @param id Id del producto return El listado de productos paginado
			 */
			// METODO BORRAR UN PRODUCTO ADMIN
			@GetMapping("/borrar/producto/{id}")
			public String borrarProducto(@PathVariable("id") long id) {
				productoServicio.deleteById(id);
				return "redirect:/producto/verListadoProductos";
			}
			/**
			 * Metodo que muestra el formulario para editar un producto, esto lo hace un
			 * admin
			 * 
			 * @param id
			 * @param model return El formulario de registro de un producto
			 */
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
			/**
			 * Metodo que procesa el formulario para editar un producto
			 * 
			 * @param p  Producto return El listado de productos paginado
			 */
			// METODO EDITAR UN PRODUCTO(RESPUESTA) ADMIN
			@PostMapping("editarProducto/submit")
			public String procesarFormularioEditarProducto(@ModelAttribute("producto") Producto p) {
				
				productoServicio.edit(p);
				
				return "redirect:/producto/verListadoProductos";
				
			}
			/**
			 * Metodo que muestra el listado de productos paginado al cliente
			 * 
			 * @param model Modelo
			 * @param pageSize tamanyo de Pagina
			 * @param page Pagina
			 * @param nombre   Nombre return El listado de productos paginado
			 */
			@GetMapping("buscarProductosBaratos")
			public String showProductsPageCheap(@RequestParam("pageSize") Optional<Integer> pageSize,
		            @RequestParam("page") Optional<Integer> page, @RequestParam("nombre") Optional<String> nombre, Model model) {

		    	
		        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		      
		        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		        
		        String evalNombre = nombre.orElse(null);
		        
		        Page<Producto> products = null;
		        
		        if (evalNombre == null) {
		        	products = productoServicio.findAllPageable(PageRequest.of(evalPage, evalPageSize));
		        } else {
		        	products = productoServicio.findByPrecioLessThan(30.0, (PageRequest.of(evalPage, evalPageSize)));
		        }

		      
		        Pager pager = new Pager(products.getTotalPages(), products.getNumber(), BUTTONS_TO_SHOW);
		        
		        model.addAttribute("products", products);
		        model.addAttribute("selectedPageSize", evalPageSize);
		        model.addAttribute("pager", pager);
		        
		    	return "html/ListadoProductosClienteBaratos";
			
			}
}
