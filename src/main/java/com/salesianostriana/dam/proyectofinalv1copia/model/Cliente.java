package com.salesianostriana.dam.proyectofinalv1copia.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.EqualsAndHashCode;
import lombok.ToString;



/**
 * Esta clase define los metodos propios y los atributos de un cliente
 * 
 * @author Ricardo Mejias Dorado
 * @version 1.0
 * 
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("C")
public class Cliente extends Usuario{

	//Atributos
	private Integer edad;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "cliente")
	private List<Presupuesto> listaPresupuestos;

	/**Constructor completo
	 * @param id el id
	 * @param nombre el nombre
	 * @param apellidos los apellidos
	 * @param email el email
	 * @param telefono el telefono
	 * @param password la password
	 * @param edad la edad
	 * @param listaPresupuestos listado de presupuestos
	 */
	public Cliente(long id, String nombre, String apellidos, String email, String telefono, String password,
			Integer edad, List<Presupuesto> listaPresupuestos) {
		super(id, nombre, apellidos, email, telefono, password);
		this.edad = edad;
		this.listaPresupuestos = listaPresupuestos;
	}
	/**
	 * Constructor vacio
	 * 
	 * */
	public Cliente() {
		
	}

	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}



	/**
	 * @return the listaPresupuestos
	 */
	public List<Presupuesto> getListaPresupuestos() {
		return listaPresupuestos;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	

	/**
	 * @param listaPresupuestos the listaPresupuestos to set
	 */
	public void setListaPresupuestos(List<Presupuesto> listaPresupuestos) {
		this.listaPresupuestos = listaPresupuestos;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result + ((listaPresupuestos == null) ? 0 : listaPresupuestos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (listaPresupuestos == null) {
			if (other.listaPresupuestos != null)
				return false;
		} else if (!listaPresupuestos.equals(other.listaPresupuestos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [edad=" + edad + ", listaPresupuestos=" + listaPresupuestos + "]";
	}

	//Metodo helper
	public void addPresupuesto(Presupuesto p) {
		this.listaPresupuestos.add(p);
		p.setCliente(this);
		
	}
	//Metodo helper
	public void removePresupuesto(Presupuesto p) {
		this.listaPresupuestos.remove(p);
		p.setCliente(null);
		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	
	
	
}
