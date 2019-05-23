package com.salesianostriana.dam.proyectofinalv1copia.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author rmejias	
 *
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login");
		registry.addViewController("/html/AccesoDenegado");
		registry.addViewController("/html/PanelControlAdmin");
		registry.addViewController("/html/PanelControlCliente");
	}

	
	
}