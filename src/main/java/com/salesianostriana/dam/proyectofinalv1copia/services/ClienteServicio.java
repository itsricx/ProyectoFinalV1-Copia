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
 * @author rmejias
 *
 */
@Service
public class ClienteServicio extends BaseService<Cliente, Long, ClienteRepositorio> {
	
	private final ClienteRepositorio clienteRepositorio;

    public ClienteServicio(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }
	
	
	    public Page<Cliente> findAllPageable(Pageable pageable) {
	        return clienteRepositorio.findAll(pageable);
	    }
	
}
