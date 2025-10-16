package com.nadhem.produits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.nadhem.produits.entities.Developer;
import com.nadhem.produits.entities.Logiciel;

@SpringBootApplication
public class ProduitsApplication implements CommandLineRunner {
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ProduitsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Logiciel.class);
		repositoryRestConfiguration.exposeIdsFor(Developer.class);
	}

}
