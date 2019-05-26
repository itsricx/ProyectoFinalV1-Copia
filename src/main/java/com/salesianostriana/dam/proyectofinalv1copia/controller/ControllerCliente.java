package com.salesianostriana.dam.proyectofinalv1copia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	/**Constructor del controller cliente
	 * @param clienteServicio
	 */
	public ControllerCliente(ClienteServicio clienteServicio) {
		super();
		this.clienteServicio = clienteServicio;
	}

	/**
	 * Metodo que muestra el formulario de registro para un cliente
	 * 
	 * @param model return El formulario de registro
	 */
	// METODO RELLENAR FORMULARIO DE REGISTRO
	@GetMapping("nuevoCliente")
	public String mostrarFormularioRegistroCliente(Model model) {

		model.addAttribute("cliente", new Cliente());
		return "html/RegistroCliente";

	}

	/**
	 * Metodo que muestra el formulario de registro de un cliente para un admin
	 * 
	 * @param model return El formulario de registro
	 */
	// METODO RELLENAR FORMULARIO DE REGISTRO DE UN CLIENTE POR PARTE DE UN ADMIN
	@GetMapping("admin/nuevoCliente")
	public String mostrarFormularioRegistroClienteAdmin(Model model) {

		model.addAttribute("cliente", new Cliente());
		return "html/RegistroClienteAdmin";

	}

	/**
	 * Metodo que procesa la informacion del formulario de registro para un cliente
	 * 
	 * @param C return login
	 */
	// METODO ENVIAR RESPUESTA FORMULARIO DE REGISTRO
	@PostMapping("nuevoCliente/submit")
	public String procesarFormularioRegistroCliente(@ModelAttribute("cliente") Cliente C) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		C.setPassword(passwordEncoder.encode(C.getPassword()));
		clienteServicio.save(C);

		return "redirect:/login";

	}

	/**
	 * Metodo que procesa la informacion del formulario de registro de un cliente
	 * para un admin
	 * 
	 * @param C return El listado de clientes paginado
	 */
	// METODO ENVIAR RESPUESTA FORMULARIO DE REGISTRO DE CLIENTE(ADMIN)
	@PostMapping("admin/nuevoCliente/submit")
	public String procesarFormularioRegistroClienteAdmin(@ModelAttribute("cliente") Cliente C) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		C.setPassword(passwordEncoder.encode(C.getPassword()));
		clienteServicio.save(C);
		return "redirect:/cliente/admin/verListadoClientes";
	}

	/**
	 * Metodo que muestra el listado de clientes paginado al administrador
	 * 
	 * @param model
	 * @param pageSize
	 * @param page
	 * @param nombre   return El listado de clientes paginado
	 */
	// METODO LISTAR TODOS LOS CLIENTES ADMIN
	@GetMapping("/admin/verListadoClientes")
	public String showClientPageAdmin(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page, @RequestParam("nombre") Optional<String> nombre,
			Model model) {

		// Evalúa el tamaño de página. Si el parámetro es "nulo", devuelve
		// el tamaño de página inicial.
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);

		// Calcula qué página se va a mostrar. Si el parámetro es "nulo" o menor
		// que 0, se devuelve el valor inicial. De otro modo, se devuelve el valor
		// del parámetro decrementado en 1.
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

		String evalNombre = nombre.orElse(null);

		Page<Cliente> clients = null;

		if (evalNombre == null) {
			clients = clienteServicio.findAllPageable(PageRequest.of(evalPage, evalPageSize));
		} else {
			clients = clienteServicio.findByNombreContainingIgnoreCasePageable(evalNombre,
					PageRequest.of(evalPage, evalPageSize));
		}

		Pager pager = new Pager(clients.getTotalPages(), clients.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("clients", clients);
		model.addAttribute("selectedPageSize", evalPageSize);
		model.addAttribute("pager", pager);

		return "html/ListadoClientes";
	}

	/**
	 * Metodo que muestra el formulario para editar un cliente, esto lo hace un
	 * admin
	 * 
	 * @param id
	 * @param model return El formulario de registro de un cliente
	 */
	// METODO EDITAR PERFIL
	@GetMapping("editarPerfil/{id}")
	public String editarPerfil(@PathVariable("id") long id, Model model) {
		Cliente cEditar = clienteServicio.findById(id);

		if (cEditar != null) {
			model.addAttribute("cliente", cEditar);

		} else {
			return "html/PanelControlAdmin";

		}
		return "html/RegistroClienteAdmin";
	}

	/**
	 * Metodo que procesa el formulario para editar un cliente
	 * 
	 * @param C return El listado de clientes paginado
	 */
	// METODO EDITAR PERFIL(PROCESAR)
	@PostMapping("editarPerfil/submit")
	public String editarPerfil(@ModelAttribute("cliente") Cliente C) {
		clienteServicio.edit(C);
		return "redirect:/cliente/admin/verListadoClientes";

	}

	/**
	 * Metodo que borra un cliente, esto lo hace un admin
	 * 
	 * @param id return El listado de clientes paginado
	 */
	// METODO BORRAR UN CLIENTE ADMIN
	@GetMapping("admin/borrar/cliente/{id}")
	public String borrarCliente(@PathVariable("id") long id) {
		clienteServicio.deleteById(id);
		return "redirect:/cliente/admin/verListadoClientes";
	}

	/**
	 * Metodo que redirecciona al panel de control
	 * 
	 * return El panel de control del cliente
	 */
	@GetMapping("accederPanelControlCliente")
	public String accederPanelCliente() {
		return "html/PanelControlCliente";
	}
	
	@GetMapping("Contacto")
	public String accederContacto() {
		return "html/Contacto";
	}

}