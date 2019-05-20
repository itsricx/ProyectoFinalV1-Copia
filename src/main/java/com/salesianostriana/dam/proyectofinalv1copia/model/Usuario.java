/**
 * 
 */
package com.salesianostriana.dam.proyectofinalv1copia.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



/**
 * @author rmejias
 *@version 1.0
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario implements UserDetails {

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
	private String password;
	
	private boolean cuentaCaducada;
	private boolean cuentaBloqueada;
	private boolean credencialesCaducadas;
	
	
	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param telefono
	 * @param password
	 * @param cuentaCaducada
	 * @param cuentaBloqueada
	 * @param credencialesCaducadas
	 */
	public Usuario(long id, String nombre, String apellidos, String email, String telefono, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.cuentaCaducada = false;
		this.cuentaBloqueada = false;
		this.credencialesCaducadas = false;
	}
	
	public Usuario() {
		
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @return the cuentaCaducada
	 */
	public boolean isCuentaCaducada() {
		return cuentaCaducada;
	}


	/**
	 * @return the cuentaBloqueada
	 */
	public boolean isCuentaBloqueada() {
		return cuentaBloqueada;
	}


	/**
	 * @return the credencialesCaducadas
	 */
	public boolean isCredencialesCaducadas() {
		return credencialesCaducadas;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @param cuentaCaducada the cuentaCaducada to set
	 */
	public void setCuentaCaducada(boolean cuentaCaducada) {
		this.cuentaCaducada = cuentaCaducada;
	}


	/**
	 * @param cuentaBloqueada the cuentaBloqueada to set
	 */
	public void setCuentaBloqueada(boolean cuentaBloqueada) {
		this.cuentaBloqueada = cuentaBloqueada;
	}


	/**
	 * @param credencialesCaducadas the credencialesCaducadas to set
	 */
	public void setCredencialesCaducadas(boolean credencialesCaducadas) {
		this.credencialesCaducadas = credencialesCaducadas;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", telefono=" + telefono + ", password=" + password + ", cuentaCaducada=" + cuentaCaducada
				+ ", cuentaBloqueada=" + cuentaBloqueada + ", credencialesCaducadas=" + credencialesCaducadas + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + (credencialesCaducadas ? 1231 : 1237);
		result = prime * result + (cuentaBloqueada ? 1231 : 1237);
		result = prime * result + (cuentaCaducada ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Usuario other = (Usuario) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (credencialesCaducadas != other.credencialesCaducadas)
			return false;
		if (cuentaBloqueada != other.cuentaBloqueada)
			return false;
		if (cuentaCaducada != other.cuentaCaducada)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
	@Override
	public abstract Collection<? extends GrantedAuthority> getAuthorities();


	@Override
	public String getUsername() {
		return email;
	}


	@Override
	public boolean isAccountNonExpired() {
		return !cuentaCaducada;
	}


	@Override
	public boolean isAccountNonLocked() {
		return !cuentaBloqueada;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return !credencialesCaducadas;
	}


	@Override
	public boolean isEnabled() {
		return !cuentaBloqueada;
	}
	
	
	
	
}
