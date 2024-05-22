package com.Embarque.Embarque.api.services;
import org.springframework.web.bind.annotation.RestController;

import com.Embarque.Embarque.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UsuarioControle{

	@Autowired
    private IU SQL;

    @GetMapping
	public static String hola(){
		return "Hola";
	}

	@PostMapping
	public Client criarUser(@RequestBody Client user) {
		Client newUser = SQL.save(user);
		return newUser;
	}

	@DeleteMapping("/{ID_user}")
	public String DeleteMethodName(@RequestBody String entity) {
		return entity;
	}
}
	

