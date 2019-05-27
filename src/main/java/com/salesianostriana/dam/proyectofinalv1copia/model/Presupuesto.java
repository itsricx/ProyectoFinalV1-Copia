package com.salesianostriana.dam.proyectofinalv1copia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Esta clase define los metodos propios y los atributos de un presupuesto
 * @author Ricardo Mejias Dorado
 * @version 1.0
 * 
 * */
@Entity
public class Presupuesto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(cascade=CascadeType.ALL)
	private List<LineaPresupuesto> lineasPresupuestos;
	
	@ManyToOne
	private Cliente cliente;

	

	/**Constructor completo
	 * @param id el id
	 * @param lineasPresupuestos lineas de presupuestp
	 * @param cliente el cliente
	 */
	public Presupuesto(long id, List<LineaPresupuesto> lineasPresupuestos, Cliente cliente) {
		super();
		this.id = id;
		this.lineasPresupuestos = lineasPresupuestos;
		this.cliente = cliente;
	}

	/**
	 * Constructor vacio
	 * @author Ricardo Mejias Dorado
	 * @version 1.0
	 * 
	 * */
	public Presupuesto() {
		
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
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Presupuesto [id=" + id + ", lineasPresupuestos=" + lineasPresupuestos + ", cliente=" + cliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lineasPresupuestos == null) ? 0 : lineasPresupuestos.hashCode());
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
		Presupuesto other = (Presupuesto) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (id != other.id)
			return false;
		if (lineasPresupuestos == null) {
			if (other.lineasPresupuestos != null)
				return false;
		} else if (!lineasPresupuestos.equals(other.lineasPresupuestos))
			return false;
		return true;
	}
	
	
}
