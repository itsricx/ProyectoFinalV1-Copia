package com.salesianostriana.dam.proyectofinalv1copia;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.salesianostriana.dam.proyectofinalv1copia.model.LineaPresupuesto;
import com.salesianostriana.dam.proyectofinalv1copia.model.Producto;
import com.salesianostriana.dam.proyectofinalv1copia.services.PresupuestoServicio;

public class PresupuestoServicioTests {

	PresupuestoServicio ps;
	
	//Se calcula de esta forma para no modificar el metodo, preguntar a Luis Miguel
	@Test
	public void testCalcularTotal() {
		List<LineaPresupuesto> aux = new ArrayList<LineaPresupuesto>();
		ps = new PresupuestoServicio(aux);
		LineaPresupuesto l = new LineaPresupuesto(1,new Producto(0,"Prueba","Prueba",LocalDate.of(1999, 06, 23),10.0));
		LineaPresupuesto l2 = new LineaPresupuesto(1,new Producto(1,"Prueba2","Prueba2",LocalDate.of(1998, 06, 23),10.0));

		
		aux.add(l);
		aux.add(l2);
		ps.setLineasPresupuestos(aux);
		assertEquals(20.0, ps.calcularTotal(), 0.001);
	}

	@Test
	public void testBorrarproducto() {
		List<LineaPresupuesto> aux = new ArrayList<LineaPresupuesto>();
		ps = new PresupuestoServicio(aux);
		LineaPresupuesto l = new LineaPresupuesto(1,new Producto(0,"Prueba","Prueba",LocalDate.of(1999, 06, 23),10.0));
		LineaPresupuesto l2 = new LineaPresupuesto(1,new Producto(1,"Prueba2","Prueba2",LocalDate.of(1998, 06, 23),10.0));
		aux.add(l);
		aux.add(l2);
		ps.setLineasPresupuestos(aux);
		
		ps.borrarProducto(l.getProductos());
		ps.borrarProducto(l2.getProductos());
		
		assertTrue(ps.getLineasPresupuestos().isEmpty());
	}
	
	@Test
	public void testAgregarProducto() {
		List<LineaPresupuesto> aux = new ArrayList<LineaPresupuesto>();
		ps = new PresupuestoServicio(aux);
		LineaPresupuesto l = new LineaPresupuesto(1,new Producto(0,"Prueba","Prueba",LocalDate.of(1999, 06, 23),10.0));
		LineaPresupuesto l2 = new LineaPresupuesto(1,new Producto(1,"Prueba2","Prueba2",LocalDate.of(1998, 06, 23),10.0));
		aux.add(l);
		aux.add(l2);
		ps.setLineasPresupuestos(aux);
		
		
		assertFalse(ps.getLineasPresupuestos().isEmpty());
	}
}
