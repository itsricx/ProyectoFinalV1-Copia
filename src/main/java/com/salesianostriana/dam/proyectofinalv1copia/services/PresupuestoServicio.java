package com.salesianostriana.dam.proyectofinalv1copia.services;

import java.util.ArrayList;
import java.util.List;



import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;


import com.salesianostriana.dam.proyectofinalv1copia.model.LineaPresupuesto;
import com.salesianostriana.dam.proyectofinalv1copia.model.Presupuesto;
import com.salesianostriana.dam.proyectofinalv1copia.model.Producto;
import com.salesianostriana.dam.proyectofinalv1copia.repository.PresupuestoRepositorio;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PresupuestoServicio extends BaseService<Presupuesto, Long, PresupuestoRepositorio> {

	

	// Se cambia map por list(Trabajar con arrayList es mas comodo en este caso)
	// Map<LineaPresupuesto, Integer> lineasPresupuestos = new HashMap<>();

	private List<LineaPresupuesto> lineasPresupuestos = new ArrayList<LineaPresupuesto>();

	

	
	/**Constructor completo
	 * @param lineasPresupuestos
	 */
	public PresupuestoServicio(List<LineaPresupuesto> lineasPresupuestos) {
		super();
		this.lineasPresupuestos = lineasPresupuestos;
	}


	/**
	 * @return the lineasPresupuestos
	 */
	public List<LineaPresupuesto> getLineasPresupuestos() {
		return lineasPresupuestos;
	}


	/**
	 * @param lineasPresupuestos the lineasPresupuestos to set
	 */
	public void setLineasPresupuestos(List<LineaPresupuesto> lineasPresupuestos) {
		this.lineasPresupuestos = lineasPresupuestos;
	}

	/**
	 * Metodo que borra un producto al carrito
	 *
	 * @param pr
	 * 
	 * */
	public void borrarProducto(Producto pr) {

		// Recorremos la lista
		for (int i = 0; i < lineasPresupuestos.size(); i++) {

			
			
			
			// COGEMOS EL ID DEL PRODUCTO
			if (lineasPresupuestos.get(i).getProductos().getId() == pr.getId()) {

				// SI ES UNO, BAJA A 0 Y SE BORRA
				if (lineasPresupuestos.get(i).getCantidad() == 1) {

					lineasPresupuestos.remove(i);
				}
				else {

					lineasPresupuestos.get(i).setCantidad(lineasPresupuestos.get(i).getCantidad() - 1);
					
				}
				
			}
			

		}
	}
	/**
	 * Metodo que agrega un producto al carrito
	 *
	 * @param pr
	 * 
	 * */
	public void agregarProducto(Producto pr) {

		// Creamos variable para salir del bucle
		Boolean accept = false;

		for (LineaPresupuesto lp : lineasPresupuestos) {

			if (lp.getProductos().getId() == pr.getId()) {
				lp.setCantidad(lp.getCantidad() + 1);
				accept = true;
			}
		}

		if (accept == false) {
			
			lineasPresupuestos.add(new LineaPresupuesto(1,pr));
		}
	}
	/**
	 * Metodo que calcula el total de los productos en el carrito
	 * 
	 * return El total del carrito actual
	 * */
	
	public Double calcularTotal() {

		
		double total = 0.0;

		if (lineasPresupuestos != null) {
			for (LineaPresupuesto lpr : lineasPresupuestos) {
				total += lpr.getProductos().getPrecio() * lpr.getCantidad();
			}
			return total;
		}

		return 0.0;

	}


	
	

}
