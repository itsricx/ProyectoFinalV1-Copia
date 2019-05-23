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
			
			Cliente cliente3 = new Cliente();
			cliente3.setNombre("Miguel");
			cliente3.setEdad(20);
			cliente3.setApellidos("Mejias");
			cliente3.setTelefono("6502944");
			cliente3.setEmail("cliente3.cliente3@salesianostriana.com");
			cliente3.setPassword(passwordEncoder.encode("12345678"));
			
			servicio.save(cliente3);
			
			Cliente cliente4 = new Cliente();
			cliente4.setNombre("Luis Miguel");
			cliente4.setEdad(29);
			cliente4.setApellidos("Lopez");
			cliente4.setTelefono("6502944123");
			cliente4.setEmail("cliente4.cliente4@salesianostriana.com");
			cliente4.setPassword(passwordEncoder.encode("123456789"));
			
			servicio.save(cliente4);
			
			Cliente cliente5 = new Cliente();
			cliente5.setNombre("Javier");
			cliente5.setEdad(24);
			cliente5.setApellidos("Lopez Bosco");
			cliente5.setTelefono("62944123");
			cliente5.setEmail("cliente5.cliente5@salesianostriana.com");
			cliente5.setPassword(passwordEncoder.encode("12345678931"));
			
			servicio.save(cliente5);
			
			Cliente cliente6 = new Cliente();
			cliente6.setNombre("Marta");
			cliente6.setEdad(29);
			cliente6.setApellidos("Fernandez");
			cliente6.setTelefono("6504123");
			cliente6.setEmail("cliente6.cliente6@salesianostriana.com");
			cliente6.setPassword(passwordEncoder.encode("123456789456"));
			
			servicio.save(cliente6);
			
			Cliente cliente7 = new Cliente();
			cliente7.setNombre("Carmen");
			cliente7.setEdad(52);
			cliente7.setApellidos("Dorado");
			cliente7.setTelefono("65029413");
			cliente7.setEmail("cliente7.cliente7@salesianostriana.com");
			cliente7.setPassword(passwordEncoder.encode("22123456789"));
			
			servicio.save(cliente7);
					
		};
	}
}
