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

import com.salesianostriana.dam.proyectofinalv1copia.model.Administrador;
import com.salesianostriana.dam.proyectofinalv1copia.model.Pager;
import com.salesianostriana.dam.proyectofinalv1copia.services.AdministradorServicio;


/**
* Esta clase es la encargada de manejar las peticiones relacionadas con los administradores
* @author Rick
* @version 1.0
* */
@Controller
@RequestMapping("/admin/")
public class CrontollerAdministrador {
	
	private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    
	@Autowired
	public AdministradorServicio administradorServicio;

	/**Constructor del controller administrador
	 * @param administradorServicio
	 */
	public CrontollerAdministrador(AdministradorServicio administradorServicio) {
		super();
		this.administradorServicio = administradorServicio;
	}
	
	/**
	 * Metodo que muestra el formulario de registro de un administrador
	 * 
	 * @param model return El formulario de registro
	 */
	// METODO MOSTRAR FORMULARIO REGISTRO_DE_ADMINISTRADOR
	@GetMapping("nuevo/administrador")
	public String mostrarFormularioRegistroAdministrador(Model model) {
		
		model.addAttribute("administrador", new Administrador());
		return "html/RegistroAdmin";
	}

	/**
	 * Metodo que procesa la informacion del formulario de registro de un admin
	 * 
	 * return El listado de admins paginado
	 */
	// METODO RESPUESTA FORMULARIO REGISTRO_DE_ADMINISTRADOR
	@PostMapping("nuevo/administrador/submit")
	public String procesarFormularioRegistroAdministrador(@ModelAttribute("administrador") Administrador a) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		administradorServicio.save(a);
		a.setPassword(passwordEncoder.encode(a.getPassword()));
		return "redirect:/admin/verListadoAdmin";
	}

	/**
	 * Metodo que borra un admin
	 * 
	 * @param id return El listado de admin paginado
	 */
	//ESTO ENVIARA AL LISTADO DE ADMINISTRADORES
	// METODO BORRAR UN ADMIN
	@GetMapping("borrar/admin/{id}")
	public String borrarAdmin(@PathVariable("id") long id) {
		administradorServicio.deleteById(id);
		return "redirect:/admin/verListadoAdmin";
		
	}
	
	/**
	 * Metodo que muestra el formulario para editar un admin
	 * @param id
	 * @param model return El formulario de registro de un admin
	 */
	// METODO EDITAR UN ADMINISTRADOR
	@GetMapping("editarAdmin/{id}")
	public String mostrarFormularioEditarAdmin(@PathVariable("id") long id, Model model) {
	
		Administrador administrador = administradorServicio.findById(id);
		
		if(administrador != null) {
			model.addAttribute("administrador", administrador);
			
		}else {
			return "html/ListadoAdmin";
		}
		return "html/RegistroAdmin";
	}
	
	/**
	 * Metodo que procesa el formulario para editar un admin
	 * 
	 * @param A return El listado de admin paginado
	 */
	//ESTO ENVIARA AL LISTADO DE ADMIN
	//METODO EDITAR UN ADMINISTRADOR(PROCESAR)
	@PostMapping("editarAdmin/submit")
	public String procesarFormularioEditarAdmin(@ModelAttribute("administrador") Administrador A)
	{
		administradorServicio.edit(A);
		
		return "redirect:/admin/verListadoAdmin";
				
	}
	/**
	 * Metodo que muestra el listado de admins paginado
	 * 
	 * @param model
	 * @param pageSize
	 * @param page
	 * @param nombre   return El listado de admins paginado
	 */
	 @GetMapping("verListadoAdmin")
	 public String showAdmin(@RequestParam("pageSize") Optional<Integer> pageSize,
	            @RequestParam("page") Optional<Integer> page, @RequestParam("nombre") Optional<String> nombre, Model model) {

	    	
	        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
	        
	      
	        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

	        String evalNombre = nombre.orElse(null);
	        
	        Page<Administrador> administrators = null;
	        
	        if (evalNombre == null) {
	        	administrators = administradorServicio.findAllPageable(PageRequest.of(evalPage, evalPageSize));
	        } else {
	        	administrators = administradorServicio.findByNombreContainingIgnoreCasePageable(evalNombre, PageRequest.of(evalPage, evalPageSize));
	        }
	        
	       
	        Pager pager = new Pager(administrators.getTotalPages(), administrators.getNumber(), BUTTONS_TO_SHOW);
	        
	        model.addAttribute("administrators", administrators);
	        model.addAttribute("selectedPageSize", evalPageSize);
	        model.addAttribute("pager", pager);
	    	
	    	return "html/ListadoAdmin";
	    }
	 /**
		 * Metodo que redirecciona al panel de control
		 * 
		 * return El panel de control del admin
		 */
	 @GetMapping("accederPanelControlAdmin")
		public String accederPanelAdmin() {
			return "html/PanelControlAdmin";
		}
}
