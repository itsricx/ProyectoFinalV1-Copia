/**
 * 
 */
package com.salesianostriana.dam.proyectofinalv1copia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalv1copia.model.Cliente;
import com.salesianostriana.dam.proyectofinalv1copia.repository.ClienteRepositorio;

/**
 * @author rmejias
 *
 */
@Service
public class ClienteServicio {

	private ClienteRepositorio clienteRepositorio;

	/**
	 * @param usuarioRepositorio
	 */
	public ClienteServicio(ClienteRepositorio usuarioRepositorio) {
		super();
		this.clienteRepositorio = usuarioRepositorio;
	}

//AÑADIR
	public Cliente add(Cliente p) {

		return clienteRepositorio.save(p);
	}

//EDITAR
	public Cliente edit(Cliente p) {
		return clienteRepositorio.save(p);

	}

//BORRAR
	public void delete(Cliente p) {
		clienteRepositorio.delete(p);
	}

//BORRAR POR ID
	public void delete(Long id) {
		clienteRepositorio.deleteById(id);
	}

//BUSCAR CLIENTE
	public List<Cliente> findAll() {
		return clienteRepositorio.findAll();
	}

//BUSCAR POR ID
	public Cliente findById(Long id) {
		return clienteRepositorio.findById(id).orElse(null);
	}

	// BUSCAR POR NOMBRE
//	public List<Cliente> findByName(String name) {
//
//	}

	
}
