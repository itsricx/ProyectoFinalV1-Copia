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
import com.salesianostriana.dam.proyectofinalv1copia.model.Cliente;
import com.salesianostriana.dam.proyectofinalv1copia.model.Pager;
import com.salesianostriana.dam.proyectofinalv1copia.services.AdministradorServicio;



@Controller
@RequestMapping("/admin/")
public class CrontollerAdministrador {
	
	private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    
	@Autowired
	public AdministradorServicio administradorServicio;

	/**
	 * @param administradorServicio
	 */
	public CrontollerAdministrador(AdministradorServicio administradorServicio) {
		super();
		this.administradorServicio = administradorServicio;
	}
	

	// METODO MOSTRAR FORMULARIO REGISTRO_DE_ADMINISTRADOR
	@GetMapping("nuevo/administrador")
	public String mostrarFormularioRegistroAdministrador(Model model) {
		
		model.addAttribute("administrador", new Administrador());
		return "html/plantillaFormularioRegistroAdmin";
	}

	
	//ESTE REDIRIGIRA AL PANEL DE CONTROL DE ADMIN
	// METODO RESPUESTA FORMULARIO REGISTRO_DE_ADMINISTRADOR
	@PostMapping("nuevo/administrador/submit")
	public String procesarFormularioRegistroAdministrador(@ModelAttribute("administrador") Administrador a) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		administradorServicio.save(a);
		a.setPassword(passwordEncoder.encode(a.getPassword()));
		return "redirect:/admin/verListadoAdmin";
	}


	//ESTO ENVIARA AL LISTADO DE ADMINISTRADORES
	// METODO BORRAR UN ADMIN
	@GetMapping("borrar/admin/{id}")
	public String borrarAdmin(@PathVariable("id") long id) {
		administradorServicio.deleteById(id);
		return "redirect:/admin/verListadoAdmin";
		
	}
	
	
	// METODO EDITAR UN ADMINISTRADOR
	@GetMapping("editarAdmin/{id}")
	public String mostrarFormularioEditarAdmin(@PathVariable("id") long id, Model model) {
	
		Administrador administrador = administradorServicio.findById(id);
		
		if(administrador != null) {
			model.addAttribute("administrador", administrador);
			
		}else {
			return "html/plantillaListadoAdmin";
		}
		return "html/plantillaFormularioRegistroAdmin";
	}
	
	
	//ESTO ENVIARA AL LISTADO DE ADMIN
	//METODO EDITAR UN ADMINISTRADOR(PROCESAR)
	@PostMapping("editarAdmin/submit")
	public String procesarFormularioEditarAdmin(@ModelAttribute("administrador") Administrador A)
	{
		administradorServicio.edit(A);
		
		return "redirect:/admin/verListadoAdmin";
				
	}
	
	 @GetMapping("verListadoAdmin")
	    public String verListadoAdmin(@RequestParam("pageSize") Optional<Integer> pageSize,
	            @RequestParam("page") Optional<Integer> page, Model model) {

	    	// Evalúa el tamaño de página. Si el parámetro es "nulo", devuelve
	    	// el tamaño de página inicial.
	        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
	        
	        // Calcula qué página se va a mostrar. Si el parámetro es "nulo" o menor
	        // que 0, se devuelve el valor inicial. De otro modo, se devuelve el valor
	        // del parámetro decrementado en 1.
	        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

	        // Obtenemos la página definida por evalPage y evalPageSize de objetos de nuestro modelo
	        Page<Administrador> administrators = administradorServicio.findAllPageable(PageRequest.of(evalPage, evalPageSize));
	        // Creamos el objeto Pager (paginador) indicando los valores correspondientes.
	        // Este sirve para que la plantilla sepa cuantas páginas hay en total, cuantos botones
	        // debe mostrar y cuál es el número de objetos a dibujar.
	        Pager pager = new Pager(administrators.getTotalPages(), administrators.getNumber(), BUTTONS_TO_SHOW);
	        
	        model.addAttribute("administrators", administrators);
	        model.addAttribute("selectedPageSize", evalPageSize);
	        model.addAttribute("pager", pager);
	    	
	    	return "html/PlantillaListadoAdmin";
	    }
}
