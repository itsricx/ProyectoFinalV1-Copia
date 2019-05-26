/**
 * 
 */
package com.salesianostriana.dam.proyectofinalv1copia.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalv1copia.model.Cliente;
import com.salesianostriana.dam.proyectofinalv1copia.repository.ClienteRepositorio;
/**
 * Esta clase conlleva toda la logica de negocio en lo referente al Cliente
 * Los metodos aqui contenidos llaman al repositorio para recoger la informacion
 * @author Rick
 * */
@Service
public class ClienteServicio extends BaseService<Cliente, Long, ClienteRepositorio> {

	private final ClienteRepositorio clienteRepositorio;

	/**
	 * Constructor de cliente servicio
	 * @param clienteRepositorio
	 * */
	public ClienteServicio(ClienteRepositorio clienteRepositorio) {
		this.clienteRepositorio = clienteRepositorio;
	}
	/**
	 * Encuentra a todos los clientes paginados
	 * @param pageable
	 * */
	public Page<Cliente> findAllPageable(Pageable pageable) {
		return clienteRepositorio.findAll(pageable);
	}
	/**
	 * Encuentra a todos los objetos por su nombre
	 * @param search
	 * */
	public Object findByNombre(String search) {

		return clienteRepositorio.findByNombreContainingIgnoreCase(search);
	}
	/**
	 * Encuentra a todos los clientes por su nombre paginados
	 * @param nombre
	 * @param pageable
	 * */
	public Page<Cliente> findByNombreContainingIgnoreCasePageable(String nombre, Pageable pageable) {
		return clienteRepositorio.findByNombreContainingIgnoreCase(nombre, pageable);
	}

	
	
}
