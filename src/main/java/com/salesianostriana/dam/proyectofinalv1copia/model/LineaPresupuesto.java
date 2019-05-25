/**
 * 
 */
package com.salesianostriana.dam.proyectofinalv1copia.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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
	
	@OneToMany(mappedBy = "lineaPresupuesto")
	private List<Producto> listadoProductos;

	
	
	public LineaPresupuesto(long id, Presupuesto presupuesto, List<Producto> listadoProductos) {
		super();
		this.id = id;
		this.presupuesto = presupuesto;
		this.listadoProductos = listadoProductos;
	}



	public LineaPresupuesto() {
		
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Presupuesto getPresupuesto() {
		return presupuesto;
	}



	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}



	public List<Producto> getListadoProductos() {
		return listadoProductos;
	}



	public void setListadoProductos(List<Producto> listadoProductos) {
		this.listadoProductos = listadoProductos;
	}



	@Override
	public String toString() {
		return "LineaPresupuesto [id=" + id + ", presupuesto=" + presupuesto + ", listadoProductos=" + listadoProductos
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((listadoProductos == null) ? 0 : listadoProductos.hashCode());
		result = prime * result + ((presupuesto == null) ? 0 : presupuesto.hashCode());
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
		if (listadoProductos == null) {
			if (other.listadoProductos != null)
				return false;
		} else if (!listadoProductos.equals(other.listadoProductos))
			return false;
		if (presupuesto == null) {
			if (other.presupuesto != null)
				return false;
		} else if (!presupuesto.equals(other.presupuesto))
			return false;
		return true;
	}

	public void addProducto(Producto p) {
		this.listadoProductos.add(p);
		p.setLineaPresupuesto(this);
		
	}
	
	public void removeProducto(Producto p) {
		this.listadoProductos.remove(p);
		p.setLineaPresupuesto(null);
	
	
	}
	
	
	
	
	
	
	
}
