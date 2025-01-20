package com.api.LaBibliotecaDeCoper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.api.LaBibliotecaDeCoper.models")
@EnableJpaRepositories("com.api.LaBibliotecaDeCoper.repositories")
public class LaBibliotecaDeCoperApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaBibliotecaDeCoperApplication.class, args);
	}

}
