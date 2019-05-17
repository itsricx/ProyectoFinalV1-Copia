package com.salesianostriana.dam.proyectofinalv1copia.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.ToString;



@Entity
public class Presupuesto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombrePresupuesto;
	private Double total;
	private Integer IVA;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "presupuesto")
	private List<LineaPresupuesto> lineasPresupuestos;
	
	@ManyToOne
	private Cliente cliente;

	/**
	 * @param id
	 * @param nombrePresupuesto
	 * @param total
	 * @param iVA
	 * @param lineasPresupuestos
	 * @param cliente
	 */
	public Presupuesto(long id, String nombrePresupuesto, Double total, Integer iVA,
			List<LineaPresupuesto> lineasPresupuestos, Cliente cliente) {
		super();
		this.id = id;
		this.nombrePresupuesto = nombrePresupuesto;
		this.total = total;
		IVA = iVA;
		this.lineasPresupuestos = lineasPresupuestos;
		this.cliente = cliente;
	}
	
	public Presupuesto() {
		
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the nombrePresupuesto
	 */
	public String getNombrePresupuesto() {
		return nombrePresupuesto;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @return the iVA
	 */
	public Integer getIVA() {
		return IVA;
	}

	/**
	 * @return the lineasPresupuestos
	 */
	public List<LineaPresupuesto> getLineasPresupuestos() {
		return lineasPresupuestos;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param nombrePresupuesto the nombrePresupuesto to set
	 */
	public void setNombrePresupuesto(String nombrePresupuesto) {
		this.nombrePresupuesto = nombrePresupuesto;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * @param iVA the iVA to set
	 */
	public void setIVA(Integer iVA) {
		IVA = iVA;
	}

	/**
	 * @param lineasPresupuestos the lineasPresupuestos to set
	 */
	public void setLineasPresupuestos(List<LineaPresupuesto> lineasPresupuestos) {
		this.lineasPresupuestos = lineasPresupuestos;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Presupuesto [id=" + id + ", nombrePresupuesto=" + nombrePresupuesto + ", total=" + total + ", IVA="
				+ IVA + ", lineasPresupuestos=" + lineasPresupuestos + ", cliente=" + cliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IVA == null) ? 0 : IVA.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lineasPresupuestos == null) ? 0 : lineasPresupuestos.hashCode());
		result = prime * result + ((nombrePresupuesto == null) ? 0 : nombrePresupuesto.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		if (IVA == null) {
			if (other.IVA != null)
				return false;
		} else if (!IVA.equals(other.IVA))
			return false;
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
		if (nombrePresupuesto == null) {
			if (other.nombrePresupuesto != null)
				return false;
		} else if (!nombrePresupuesto.equals(other.nombrePresupuesto))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	
	public void addLineaPresupuesto(LineaPresupuesto lp) {
		this.lineasPresupuestos.add(lp);
		lp.setPresupuesto(this);
		
	}
	
	public void removeLineaPresupuesto(LineaPresupuesto lp) {
		this.lineasPresupuestos.remove(lp);
		lp.setPresupuesto(null);
	}
	
	
}
