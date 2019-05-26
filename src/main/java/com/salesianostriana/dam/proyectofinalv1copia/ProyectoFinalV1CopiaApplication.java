package com.salesianostriana.dam.proyectofinalv1copia;



import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.salesianostriana.dam.proyectofinalv1copia.model.Usuario;
import com.salesianostriana.dam.proyectofinalv1copia.services.UsuarioServicio;
/**
 * Esta clase es la encargada de arrancar la app
 * @author Rick
 * @version 1.0
 * */
@SpringBootApplication
public class ProyectoFinalV1CopiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalV1CopiaApplication.class, args);
	
	
	
	
	
	
	}
/**
 * Metodo que encripta las contraseñas a los usuarios añadidos desde el data.sql
 *@param usuarioServicio
 *@param passwordEncoder 
 * */
	@Bean
	public CommandLineRunner init(UsuarioServicio usuarioServicio, BCryptPasswordEncoder passwordEncoder) {
		return args -> {

			List<Usuario> listaHermanos = usuarioServicio.findAll();

			for (Usuario u : listaHermanos) {
				u.setPassword(passwordEncoder.encode(u.getPassword()));
				usuarioServicio.edit(u);
			}

		};
	}
	}
