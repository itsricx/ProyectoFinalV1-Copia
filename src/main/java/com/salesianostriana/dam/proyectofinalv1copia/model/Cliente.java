package com.salesianostriana.dam.proyectofinalv1copia.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.ToString;



/**
 * Esta clase define los metodos propios y los atributos de un cliente
 * @author Ricardo Mejias Dorado
 * @version 1.0
 * 
 * */
@Entity
@DiscriminatorValue("C")
public class Cliente extends Usuario{

	//Atributos
	private Integer edad;
	private Character sexo;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "cliente")
	private List<Presupuesto> listaPresupuestos;

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param telefono
	 * @param password
	 * @param edad
	 * @param sexo
	 * @param listaPresupuestos
	 */
	public Cliente(long id, String nombre, String apellidos, String email, String telefono, String password,
			Integer edad, Character sexo, List<Presupuesto> listaPresupuestos) {
		super(id, nombre, apellidos, email, telefono, password);
		this.edad = edad;
		this.sexo = sexo;
		this.listaPresupuestos = listaPresupuestos;
	}
	
	public Cliente() {
		
	}

	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}

	/**
	 * @return the sexo
	 */
	public Character getSexo() {
		return sexo;
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
	 * @param sexo the sexo to set
	 */
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	/**
	 * @param listaPresupuestos the listaPresupuestos to set
	 */
	public void setListaPresupuestos(List<Presupuesto> listaPresupuestos) {
		this.listaPresupuestos = listaPresupuestos;
	}

	@Override
	public String toString() {
		return "Cliente [edad=" + edad + ", sexo=" + sexo + ", listaPresupuestos=" + listaPresupuestos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result + ((listaPresupuestos == null) ? 0 : listaPresupuestos.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
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
	

	
	
	
	
}
