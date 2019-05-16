package com.salesianostriana.dam.proyectofinalv1copia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinalv1copia.model.Cliente;
import com.salesianostriana.dam.proyectofinalv1copia.services.ClienteServicio;

@Controller
@RequestMapping("/cliente/")
public class ControllerCliente {

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
	@GetMapping("/nuevoCliente")
	public String mostrarFormularioRegistroCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "html/plantillaFormularioRegistroCliente";
		
	}
	//METODO ENVIAR RESPUESTA FORMULARIO DE REGISTRO
	@PostMapping("/nuevoCliente/submit")
	public String procesarFormularioRegistroCliente(@ModelAttribute("cliente") Cliente C) {
		clienteServicio.add(C);
		return "html/plantillaPanelControlCliente";
		
	}
	//METODO ENVIAR RESPUESTA FORMULARIO DE REGISTRO DE CLIENTE(ADMIN)
	@PostMapping("admin/nuevoCliente/submit")
	public String procesarFormularioRegistroClienteAdmin(@ModelAttribute("cliente") Cliente C) {
		clienteServicio.add(C);
		return "html/pruebaAgregarClienteAdmin";
	}
	
	//METODO RELLENAR FORMULARIO INICIO DE SESION
	@GetMapping("/inicio")
	public String mostrarFormularioInicioSesion(Model model) {
		
		return "plantillaInicioSesion";
	}
	//METODO ENVIAR RESPUESTA INICIO DE SESION
	
	
	
	// METODO LISTAR TODOS LOS CLIENTES ADMIN
		@GetMapping("admin/listadoClientes")
		public String mostrarTodosUsuarios(Model model) {
			model.addAttribute("lista", clienteServicio.findAll());
			return "html/plantillaListadoClientes";

		}
	
	//METODO EDITAR PERFIL
	@GetMapping("/editarPerfil/{id}")
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
	
	// METODO BORRAR UN CLIENTE ADMIN
	@GetMapping("admin/borrar/cliente/{id}")
	public String borrarCliente(@PathVariable("id") long id) {
		clienteServicio.delete(id);
		return "html/plantillaListadoClientes";
	}
	
	// METODO EDITAR UN CLIENTE(MOSTRAR FORMULARIO) ADMIN
	@GetMapping("admin/editarCliente/{id}")
	public String mostrarFormularioEditarCliente(@PathVariable("id") long id, Model model) {
		Cliente cEditar = clienteServicio.findById(id);

		if (cEditar != null) {
			model.addAttribute("cliente", cEditar);
		} else {
			return "html/plantillaListadoClientes";

		}

		return "html/plantillaFormularioRegistroCliente";
	}

	// METODO EDITAR UN CLIENTE(PROCESAR FORMULARIO) ADMIN
	@PostMapping("admin/editarCliente/submit")
	public String procesarFormularioEditarCliente(@ModelAttribute("cliente") Cliente C) {

		clienteServicio.edit(C);
		return "html/plantillaListadoClientes";
	}
	
	}