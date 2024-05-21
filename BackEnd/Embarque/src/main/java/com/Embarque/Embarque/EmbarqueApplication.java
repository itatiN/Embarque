package com.Embarque.Embarque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EmbarqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmbarqueApplication.class, args);
	}

	@GetMapping("/")
	public static String hola(){
		return "Hola";
	}
}
