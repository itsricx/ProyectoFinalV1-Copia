package com.salesianostriana.dam.proyectofinalv1copia.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalv1copia.model.Administrador;
import com.salesianostriana.dam.proyectofinalv1copia.model.Cliente;
import com.salesianostriana.dam.proyectofinalv1copia.repository.AdministradorRepositorio;
import com.salesianostriana.dam.proyectofinalv1copia.repository.ClienteRepositorio;


@Service
public class AdministradorServicio extends BaseService<Administrador,Long, AdministradorRepositorio> {

	private final AdministradorRepositorio administradorRepositorio;

    public AdministradorServicio(AdministradorRepositorio administradorRepositorio) {
        this.administradorRepositorio = administradorRepositorio;
    }
	
	
	    public Page<Administrador> findAllPageable(Pageable pageable) {
	        return administradorRepositorio.findAll(pageable);
	    }
	
}
