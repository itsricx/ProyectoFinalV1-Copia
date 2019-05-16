package com.salesianostriana.dam.proyectofinalv1copia.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Administrador extends Usuario {

	//Atributos
	private String DNI;

	

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param telefono
	 * @param password
	 * @param dNI
	 */
	public Administrador(long id, String nombre, String apellidos, String email, String telefono, String password,
			String dNI) {
		super(id, nombre, apellidos, email, telefono, password);
		DNI = dNI;
	}

	public Administrador() {
	}

	//Getters & setters
	/**
	 * @return the dNI
	 */
	public String getDNI() {
		return DNI;
	}


	/**
	 * @param dNI the dNI to set
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}
//metodo toString
	@Override
	public String toString() {
		return "Administrador [DNI=" + DNI +super.toString()+"]";
	}
//metodo hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		return result;
	}
//metodo equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		return true;
	}
	
	

	

	

	
	
	
	
}
