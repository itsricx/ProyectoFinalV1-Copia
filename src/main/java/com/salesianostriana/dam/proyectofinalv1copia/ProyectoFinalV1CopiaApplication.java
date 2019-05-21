package com.salesianostriana.dam.proyectofinalv1copia;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.salesianostriana.dam.proyectofinalv1copia.model.Cliente;
import com.salesianostriana.dam.proyectofinalv1copia.model.Administrador;
import com.salesianostriana.dam.proyectofinalv1copia.services.UsuarioServicio;

@SpringBootApplication
public class ProyectoFinalV1CopiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalV1CopiaApplication.class, args);
	
	
	
	
	
	
	}

	@Bean
	public CommandLineRunner init(UsuarioServicio servicio, BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			
			Administrador admin = new Administrador();
			admin.setEmail("admin.admin@salesianostriana.com");
			admin.setPassword(passwordEncoder.encode("1234"));
			
			servicio.save(admin);
			
			Cliente cliente = new Cliente();
			cliente.setEmail("cliente.cliente@salesianostriana.com");
			cliente.setPassword(passwordEncoder.encode("1234"));
			
			servicio.save(cliente);
			
			
					
		};
	}
}
