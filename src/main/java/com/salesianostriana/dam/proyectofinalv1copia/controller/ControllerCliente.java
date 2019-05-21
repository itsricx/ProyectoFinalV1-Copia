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

import com.salesianostriana.dam.proyectofinalv1copia.model.Cliente;
import com.salesianostriana.dam.proyectofinalv1copia.model.Pager;
import com.salesianostriana.dam.proyectofinalv1copia.services.ClienteServicio;

@Controller
@RequestMapping("/cliente/")
public class ControllerCliente {

	private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
	
	
	@Autowired
	private ClienteServicio clienteServicio;
	

	/**
	 * @param usuarioServicio
	 */
	public ControllerCliente(ClienteServicio clienteServicio) {
		super();
		this.clienteServicio = clienteServicio;
	}
	
	
	//METODO RELLENAR FORMULARIO DE REGISTRO
	@GetMapping("nuevoCliente")
	public String mostrarFormularioRegistroCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "html/plantillaFormularioRegistroCliente";
		
	}
	//METODO RELLENAR FORMULARIO DE REGISTRO DE UN CLIENTE POR PARTE DE UN ADMIN
	@GetMapping("admin/nuevoCliente")
	public String mostrarFormularioRegistroClienteAdmin(Model model) {
		
		model.addAttribute("cliente", new Cliente());
		return "html/plantillaFormularioRegistroClienteAdmin";
		
	}
	
	//ESTE SE MODIFICARA PARA QUE ENTRE EN EL PANEL DE CONTROL
	//METODO ENVIAR RESPUESTA FORMULARIO DE REGISTRO
	@PostMapping("nuevoCliente/submit")
	public String procesarFormularioRegistroCliente(@ModelAttribute("cliente") Cliente C) {
		clienteServicio.save(C);
		return "html/pruebaAgregarCliente";
		
	}
	//ESTO ENVIARA AL LISTADO
	//METODO ENVIAR RESPUESTA FORMULARIO DE REGISTRO DE CLIENTE(ADMIN)
	@PostMapping("admin/nuevoCliente/submit")
	public String procesarFormularioRegistroClienteAdmin(@ModelAttribute("cliente") Cliente C) {
		clienteServicio.save(C);
		return "html/plantillaListadoClientes";
	}
	
	
	
	
	
	// METODO LISTAR TODOS LOS CLIENTES ADMIN
	 @GetMapping("/admin/verListadoClientes")
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
	        Page<Cliente> clients = clienteServicio.findAllPageable(PageRequest.of(evalPage, evalPageSize));
	        // Creamos el objeto Pager (paginador) indicando los valores correspondientes.
	        // Este sirve para que la plantilla sepa cuantas páginas hay en total, cuantos botones
	        // debe mostrar y cuál es el número de objetos a dibujar.
	        Pager pager = new Pager(clients.getTotalPages(), clients.getNumber(), BUTTONS_TO_SHOW);
	        
	        model.addAttribute("clients", clients);
	        model.addAttribute("selectedPageSize", evalPageSize);
	        model.addAttribute("pager", pager);
	    	
	    	return "html/PruebaListado";
	    }
	
	//METODO EDITAR PERFIL
	@GetMapping("editarPerfil/{id}")
	public String editarPerfil(@PathVariable("id") long id,Model model) {
		Cliente cEditar = clienteServicio.findById(id);
		
		if(cEditar !=null) {
			model.addAttribute("cliente", cEditar);
				
		}
		else {
			return "html/plantillaPanelControlCliente";
			
		}
		return "html/plantillaFormularioRegistroCliente";
	}
	//METODO EDITAR PERFIL(PROCESAR)
		@PostMapping("editarPerfil/submit")
		public String editarPerfil(@ModelAttribute("cliente") Cliente C) {
			clienteServicio.edit(C);
			
			return "html/pruebaAgregarCliente";
			
		
		}
	
		
	// METODO BORRAR UN CLIENTE ADMIN
	@GetMapping("admin/borrar/cliente/{id}")
	public String borrarCliente(@PathVariable("id") long id) {
		clienteServicio.deleteById(id);
		return "html/plantillaListadoClientes";
	}
	
	}