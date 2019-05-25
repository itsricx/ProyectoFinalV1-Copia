package com.salesianostriana.dam.proyectofinalv1copia.services;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectofinalv1copia.model.LineaPresupuesto;
import com.salesianostriana.dam.proyectofinalv1copia.model.Presupuesto;
import com.salesianostriana.dam.proyectofinalv1copia.repository.LineaPresupuestoRepositorio;
import com.salesianostriana.dam.proyectofinalv1copia.repository.PresupuestoRepositorio;


@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PresupuestoServicio extends BaseService<Presupuesto, Long, PresupuestoRepositorio> {

	private LineaPresupuestoRepositorio lineaPresupuestoRepositorio;
	
	Map<LineaPresupuesto, Integer> lineasPresupuestos = new HashMap<>();
	
	
	
	public PresupuestoServicio(LineaPresupuestoRepositorio lineaPresupuestoRepositorio,
			Map<LineaPresupuesto, Integer> lineasPresupuestos) {
		super();
		this.lineaPresupuestoRepositorio = lineaPresupuestoRepositorio;
		this.lineasPresupuestos = lineasPresupuestos;
	}

	public Map<LineaPresupuesto, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(lineasPresupuestos);
    }

	public void removeLineaPresupuesto (LineaPresupuesto lp) {
        if(lineasPresupuestos.containsKey(lp)) {
        	
        	if(lineasPresupuestos.get(lp) >1)
        		lineasPresupuestos.replace(lp, lineasPresupuestos.get(lp)-1);
        }
        else if(lineasPresupuestos.get(lp)== 1){
        	lineasPresupuestos.remove(lp);
        	
        }
	}
	
	public void addLineaPresupuesto (LineaPresupuesto lp) {
		if (lineasPresupuestos.containsKey(lp)) {
			lineasPresupuestos.replace(lp, lineasPresupuestos.get(lp)+1);
		}else {
			lineasPresupuestos.put(lp, 1);
		}
	}
	

}
