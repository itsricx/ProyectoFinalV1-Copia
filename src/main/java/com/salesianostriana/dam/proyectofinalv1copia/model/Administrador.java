package com.salesianostriana.dam.proyectofinalv1copia.model;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;



/**
 * Esta clase define los metodos propios y los atributos de un administrador
 * 
 * @author Ricardo Mejias Dorado
 * @version 1.0
 * 
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("A")
public class Administrador extends Usuario {

	//Atributos
	private String DNI;

	

	/**Constructor completo
	 * @param id el id
	 * @param nombre el nombre
	 * @param apellidos los apellidos
	 * @param email el email
	 * @param telefono el telefono
	 * @param password la password
	 * @param dNI el dni
	 */
	public Administrador(long id, String nombre, String apellidos, String email, String telefono, String password,
			String dNI) {
		super(id, nombre, apellidos, email, telefono, password);
		DNI = dNI;
	}

	/**
	 * Constructor vacio
	 * 
	 * */
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
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	

	

	
	
	
	
}
