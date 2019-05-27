/**
 * 
 */
package com.salesianostriana.dam.proyectofinalv1copia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Esta clase define los metodos propios y los atributos de una Linea de
 * presupuesto
 * 
 * @author Ricardo Mejias Dorado
 * @version 1.0
 * 
 */
@Entity
public class LineaPresupuesto {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Integer cantidad;
	@ManyToOne
	private Producto productos;

	/**
	 * Constructor completo
	 * 
	 * @param id el id
	 * @param cantidad la cantidad
	 * @param productos los productos
	 */
	public LineaPresupuesto(long id, Integer cantidad, Producto productos) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.productos = productos;
	}

	/**
	 * Construcor sin id
	 * 
	 * @param cantidad la cantidad
	 * @param productos los productos
	 */
	public LineaPresupuesto(Integer cantidad, Producto productos) {
		super();
		this.cantidad = cantidad;
		this.productos = productos;
	}

	/**
	 * Constructor vacio
	 * 
	 */
	public LineaPresupuesto() {

	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the productos
	 */
	public Producto getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(Producto productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "LineaPresupuesto [id=" + id + ", cantidad=" + cantidad + ", productos=" + productos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaPresupuesto other = (LineaPresupuesto) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (id != other.id)
			return false;
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		return true;
	}

}
