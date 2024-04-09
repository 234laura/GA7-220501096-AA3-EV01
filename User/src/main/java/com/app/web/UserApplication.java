package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entidad.Usuario;
import com.app.web.repositorio.UsuarioRepositorio;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Override
	public void run(String... args) throws Exception {
		/*Usuario usuario1= new Usuario("Laura","Lau@gmail.com","Lau123");
		repositorio.save(usuario1);
		
		Usuario usuario2= new Usuario("Daniela","Dani@gmail.com","123df");
		repositorio.save(usuario2);
		*/
	}

}
