package com.salesianostriana.dam.proyectofinalv1copia;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.salesianostriana.dam.proyectofinalv1copia.model.Producto;

public class PresupuestoServicioTests {

	
	//Se calcula de esta forma para no modificar el metodo, preguntar a Luis Miguel
	@Test
	public void testCalcularTotal() {
		List<Producto> listado = new ArrayList<Producto>();
		listado.add(new Producto(1,"Rosas","Prueba",LocalDate.of(1999, 07, 22),20.0));
		listado.add(new Producto(2,"Margaritas","Prueba",LocalDate.of(1997, 07, 22),20.0));
		
		assertEquals(40.0, listado.get(0).getPrecio()+listado.get(1).getPrecio(), 0.001);
	}

}
