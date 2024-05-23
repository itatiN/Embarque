package com.Embarque.Embarque.api.controller;
import org.springframework.web.bind.annotation.RestController;

import com.Embarque.Embarque.api.services.UserService;
import com.Embarque.Embarque.models.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UsuarioControle{
	@Autowired
    private UserService UserService;

    @GetMapping
	public static String hola(){
		return "Hola";
	}

	@PostMapping
	public Cliente criarcClient(@RequestBody Cliente cliente) {
		return UserService.saveCliente(cliente);
	}

	@DeleteMapping("/{ID_user}")
	public String DeleteMethodName(@RequestBody String entity) {
		return entity;
	}
}
	

