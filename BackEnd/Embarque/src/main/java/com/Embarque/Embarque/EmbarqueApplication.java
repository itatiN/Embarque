package com.Embarque.Embarque;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmbarqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmbarqueApplication.class, args);
		System.out.println("Embarque Application is running!");
	}
}