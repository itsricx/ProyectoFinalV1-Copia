package com.salesianostriana.dam.proyectofinalv1copia.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.salesianostriana.dam.proyectofinalv1copia.model.Producto;
import com.salesianostriana.dam.proyectofinalv1copia.repository.ProductoRepositorio;

@Service
public class ProductoServicio extends BaseService<Producto, Long, ProductoRepositorio> {

	private final ProductoRepositorio productoRepositorio;

    public  ProductoServicio(ProductoRepositorio productoRepositorio) {
    	this.productoRepositorio = productoRepositorio;
    }
	
	
	    public Page<Producto> findAllPageable(Pageable pageable) {
	        return productoRepositorio.findAll(pageable);
	    }
}
