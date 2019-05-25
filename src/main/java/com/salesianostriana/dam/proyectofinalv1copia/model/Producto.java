package com.salesianostriana.dam.proyectofinalv1copia.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.ToString;



@Entity
public class Producto {

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombre;
	private String descripcion;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaEntrada;
	private Double precio;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	private LineaPresupuesto lineaPresupuesto;

	
	
	public Producto(long id, String nombre, String descripcion, LocalDate fechaEntrada, Double precio,
			LineaPresupuesto lineaPresupuesto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaEntrada = fechaEntrada;
		this.precio = precio;
		this.lineaPresupuesto = lineaPresupuesto;
	}


	public Producto() {
		
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}



	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	/**
	 * @return the fechaEntrada
	 */
	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}



	/**
	 * @param fechaEntrada the fechaEntrada to set
	 */
	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}



	/**
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}



	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	/**
	 * @return the lineaPresupuesto
	 */
	public LineaPresupuesto getLineaPresupuesto() {
		return lineaPresupuesto;
	}



	/**
	 * @param lineaPresupuesto the lineaPresupuesto to set
	 */
	public void setLineaPresupuesto(LineaPresupuesto lineaPresupuesto) {
		this.lineaPresupuesto = lineaPresupuesto;
	}



	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaEntrada="
				+ fechaEntrada + ", precio=" + precio + ", lineaPresupuesto=" + lineaPresupuesto + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaEntrada == null) ? 0 : fechaEntrada.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lineaPresupuesto == null) ? 0 : lineaPresupuesto.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		Producto other = (Producto) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaEntrada == null) {
			if (other.fechaEntrada != null)
				return false;
		} else if (!fechaEntrada.equals(other.fechaEntrada))
			return false;
		if (id != other.id)
			return false;
		if (lineaPresupuesto == null) {
			if (other.lineaPresupuesto != null)
				return false;
		} else if (!lineaPresupuesto.equals(other.lineaPresupuesto))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	
	
	
}
