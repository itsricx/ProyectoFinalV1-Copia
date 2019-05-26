package com.salesianostriana.dam.proyectofinalv1copia.services;




import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.salesianostriana.dam.proyectofinalv1copia.model.Producto;
import com.salesianostriana.dam.proyectofinalv1copia.repository.ProductoRepositorio;

/**
 * Esta clase conlleva toda la logica de negocio en lo referente al Producto
 * Los metodos aqui contenidos llaman al repositorio para recoger la informacion
 * @author Rick
 * */
@Service
public class ProductoServicio extends BaseService<Producto, Long, ProductoRepositorio> {

	private final ProductoRepositorio productoRepositorio;

	@Autowired
	EntityManager entityManager;
	/**
	 * Constructor de Producto servicio
	 * @param productoRepositorio
	 * */
    public  ProductoServicio(ProductoRepositorio productoRepositorio) {
    	this.productoRepositorio = productoRepositorio;
    }
	
    /**
	 * Encuentra a todos los Productos paginados
	 * @param pageable
	 * */
	    public Page<Producto> findAllPageable(Pageable pageable) {
	        return productoRepositorio.findAll(pageable);
	    }

	    /**
		 * Encuentra a todos los objetos por su nombre
		 * @param search
		 * */
		public Object findByNombre(String search) {
			
			return productoRepositorio.findByNombreContainingIgnoreCase(search);
		}
		 /**
		 * Encuentra a todos los Productos por su nombre paginados
		 * @param nombre
		 * @param pageable
		 * */
		public  Page<Producto> findByNombreContainingIgnoreCasePageable(String nombre, Pageable pageable)
		{
			return productoRepositorio.findByNombreContainingIgnoreCase(nombre, pageable);
		}
		
		public Page<Producto> findByPrecioLessThan(Double precio, Pageable pageable){
			
			return productoRepositorio.findByPrecioLessThan(precio, pageable);
		}
		
		

	}
		

