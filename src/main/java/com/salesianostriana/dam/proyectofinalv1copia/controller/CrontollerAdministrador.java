package com.salesianostriana.dam.proyectofinalv1copia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinalv1copia.model.Administrador;
import com.salesianostriana.dam.proyectofinalv1copia.services.AdministradorServicio;

/*LA LOGICA DE NEGOCIO VA EN LOS SERVICIOS, POR EJEMPLOS SI FILTRAMOS PRODUCTOS ESTO
 * IRA EN PRODUCTOSERVICIO Y TENDRA UNA INSTANCIA EN ADMINISTRADOR POR EJEMPLO, 
 * QUE ES EL QUE FILTRA
 * 
 * LA LOGICA DE NEGOCIO TIRARA A LA BASE DE DATOS CUANDO SEA NECESARIO(PREGUNTAR A LUISMI)
 * 
 * EN LOS SERVICIOS VA "LO QUE SE PUEDE HACER SOBRE LOS OBJETOS"
 * 
 * EN LAS CRUD VA "QUIEN HACE LA ACCION SOBRE LOS OBJETOS"
 * 
 * PREGUNTAR ACERCA DE LOS NOMBRES QUE SE METEN EN LOS POST Y GETMAPPING
 * 
 * POR ULTIMO, PREGUNTAR A ANGEL LA INCLUSION DE LAS PLANTILLAS EN THYMELEAF
 * 
 * 
 */

@Controller
@RequestMapping("/admin/")
public class CrontollerAdministrador {

	@Autowired
	public AdministradorServicio administradorServicio;

	/**
	 * @param administradorServicio
	 */
	public CrontollerAdministrador(AdministradorServicio administradorServicio) {
		super();
		this.administradorServicio = administradorServicio;
	}
	
	// METODO MOSTRAR FORMULARIO INICIO DE SESION

	
	
	// METODO RESPUESTA FORMULARIO INICIO DE SESION

	
	// METODO MOSTRAR FORMULARIO REGISTRO_DE_ADMINISTRADOR
	@GetMapping("nuevo/administrador")
	public String mostrarFormularioRegistroAdministrador(Model model) {
		model.addAttribute("administrador", new Administrador());
		return "html/plantillaFormularioRegistroAdministrador";
	}

	
	
	// METODO RESPUESTA FORMULARIO REGISTRO_DE_ADMINISTRADOR
	@PostMapping("nuevo/administrador/submmit")
	public String procesarFormularioRegistroAdministrador(@ModelAttribute("administrador") Administrador a) {
		administradorServicio.add(a);
		return "html/plantillaPanelControlAdmin";
	}


	
	// METODO BORRAR UN ADMIN
	@GetMapping("borrar/admin/{id}")
	public String borrarAdmin(@PathVariable("id") long id) {
		administradorServicio.delete(id);
		return "htm/plantillaListadoAdmin";
		
	}
	
	
	// METODO EDITAR UN ADMINISTRADOR
	@GetMapping("editarAdmin/{id}")
	public String mostrarFormularioEditarAdmin(@PathVariable("id") long id, Model model) {
	
		Administrador cAdministrador = administradorServicio.findById(id);
		
		if(cAdministrador != null) {
			model.addAttribute("administrador", cAdministrador);
			
		}else {
			return "html/plantillaListadoAdmin";
		}
		return "html/plantillaFormularioRegistroAdmin";
	}
	
	
	
	//METODO EDITAR UN ADMINISTRADOR(PROCESAR)
	@PostMapping("editarAdmin/submit")
	public String procesarFormularioEditarAdmin(@ModelAttribute("administrador") Administrador A)
	{
		administradorServicio.edit(A);
		
		return "html/plantillaListadoAdmin";
				
	}
}
