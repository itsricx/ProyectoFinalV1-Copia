package com.salesianostriana.dam.proyectofinalv1copia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalv1copia.model.Producto;
import com.salesianostriana.dam.proyectofinalv1copia.repository.ProductoRepositorio;

@Service
public class ProductoServicio {

	//Inyectamos la dependencia
	private ProductoRepositorio productoRepositorio;

	//Constructor
	/**
	 * @param productoRepositorio
	 */
	public ProductoServicio(ProductoRepositorio productoRepositorio) {
		super();
		this.productoRepositorio = productoRepositorio;
	}
	
	public Producto add(Producto p) {
		
		return productoRepositorio.save(p);
	}
	
	public Producto edit(Producto p) {
		return productoRepositorio.save(p);
		
	}
	public void delete(Producto p) {
		productoRepositorio.delete(p);
	}
	public void delete(Long id) {
		productoRepositorio.deleteById(id);
	}
	public List<Producto> findAll(){
		return productoRepositorio.findAll();
	}
	public Producto findById(Long id) {
		return productoRepositorio.findById(id).orElse(null);
	}
	
}
