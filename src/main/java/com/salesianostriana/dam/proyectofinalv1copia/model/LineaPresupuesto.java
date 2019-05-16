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
 * @author Rick
 *
 */
@Entity
public class LineaPresupuesto {

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Presupuesto presupuesto;
	
	@ManyToOne
	private Producto producto;

	/**
	 * @param id
	 * @param presupuesto
	 * @param producto
	 */
	public LineaPresupuesto(long id, Presupuesto presupuesto, Producto producto) {
		super();
		this.id = id;
		this.presupuesto = presupuesto;
		this.producto = producto;
	}
	
	public LineaPresupuesto() {
		
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the presupuesto
	 */
	public Presupuesto getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param presupuesto the presupuesto to set
	 */
	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "LineaPresupuesto [id=" + id + ", presupuesto=" + presupuesto + ", producto=" + producto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((presupuesto == null) ? 0 : presupuesto.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		if (id != other.id)
			return false;
		if (presupuesto == null) {
			if (other.presupuesto != null)
				return false;
		} else if (!presupuesto.equals(other.presupuesto))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}
	
	
	
	
	
	
}
