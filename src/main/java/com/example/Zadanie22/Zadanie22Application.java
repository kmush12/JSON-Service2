package com.example.Zadanie22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class Zadanie22Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Zadanie22Application.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8081"));
		app.run(args);
	}

}
