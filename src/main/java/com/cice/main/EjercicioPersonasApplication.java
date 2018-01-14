package com.cice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cice.negocio.Gestora;

@SpringBootApplication
/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */
public class EjercicioPersonasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPersonasApplication.class, args);
		
		Gestora gestora = new Gestora();
		
		gestora.showMenu();
	}
}
