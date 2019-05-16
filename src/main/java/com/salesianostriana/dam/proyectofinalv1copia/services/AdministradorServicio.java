package com.salesianostriana.dam.proyectofinalv1copia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalv1copia.model.Administrador;
import com.salesianostriana.dam.proyectofinalv1copia.repository.AdministradorRepositorio;


@Service
public class AdministradorServicio {

	//Inyectamos la dependencia
		private AdministradorRepositorio administradorRepositorio;

		
		//Constructor
		public AdministradorServicio(AdministradorRepositorio administradorRepositorio) {
		super();
		this.administradorRepositorio = administradorRepositorio;
	}

		//AÑADIR
		public Administrador add(Administrador p) {
			
			return administradorRepositorio.save(p);
		}
		//EDITAR
		public Administrador edit(Administrador p) {
			return administradorRepositorio.save(p);
			
		}
		//BORRAR
		public void delete(Administrador p) {
			administradorRepositorio.delete(p);
		}
		//BORRAR POR ID
		public void delete(Long id) {
			administradorRepositorio.deleteById(id);
		}
		//BUSCAR TODOS
		public List<Administrador> findAll(){
			return administradorRepositorio.findAll();
		}
		//BUSCAR POR ID
		public Administrador findById(Long id) {
			return administradorRepositorio.findById(id).orElse(null);
		}
		//BUSCAR POR NOMBRE
//		public List<Administrador> findByName(String name){
//			
//		}
		//bUSCAR POR DNI
//		public Administrador findByDNI(String dni){
//			
//		}
}
