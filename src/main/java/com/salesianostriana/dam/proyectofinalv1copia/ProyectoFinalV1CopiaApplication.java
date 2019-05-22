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
			cliente.setNombre("Ricardo");
			cliente.setEdad(18);
			cliente.setApellidos("Mejias");
			cliente.setEmail("cliente.cliente@salesianostriana.com");
			cliente.setTelefono("65029913");
			cliente.setPassword(passwordEncoder.encode("1234"));
			
			servicio.save(cliente);

			Cliente cliente2 = new Cliente();
			cliente2.setNombre("Miguel");
			cliente2.setEdad(20);
			cliente2.setApellidos("Diaz");
			cliente2.setTelefono("65029933");
			cliente2.setEmail("cliente2.cliente2@salesianostriana.com");
			cliente2.setPassword(passwordEncoder.encode("12345"));
			
			servicio.save(cliente2);
			
			
					
		};
	}
}
