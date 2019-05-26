package com.salesianostriana.dam.proyectofinalv1copia.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalv1copia.model.Administrador;
import com.salesianostriana.dam.proyectofinalv1copia.repository.AdministradorRepositorio;


/**
 * Esta clase conlleva toda la logica de negocio en lo referente al administrador
 * Los metodos aqui contenidos llaman al repositorio para recoger la informacion
 * @author Rick
 * */
@Service
public class AdministradorServicio extends BaseService<Administrador,Long, AdministradorRepositorio> {

	private final AdministradorRepositorio administradorRepositorio;
	/**
	 * Constructor de administrador servicio
	 * @param administradorRepositorio
	 * */
    public AdministradorServicio(AdministradorRepositorio administradorRepositorio) {
        this.administradorRepositorio = administradorRepositorio;
    }
	
    /**
	 * Encuentra a todos los administradores paginados
	 * @param pageable
	 * */
	    public Page<Administrador> findAllPageable(Pageable pageable) {
	        return administradorRepositorio.findAll(pageable);
	    }
	    
	    /**
		 * Encuentra a todos los objetos por su nombre
		 * @param search
		 * */
	    public Object findByNombre(String search) {
			
			return administradorRepositorio.findByNombreContainingIgnoreCase(search);
		}
	    /**
		 * Encuentra a todos los administradores por su nombre paginados
		 * @param nombre
		 * @param pageable
		 * */
		public  Page<Administrador> findByNombreContainingIgnoreCasePageable(String nombre, Pageable pageable)
		{
			return administradorRepositorio.findByNombreContainingIgnoreCase(nombre, pageable);
		}
	
}
