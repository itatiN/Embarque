package com.Embarque.Embarque.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Embarque.Embarque.api.services.ClienteService;
import com.Embarque.Embarque.persistance.models.Cliente;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {
   
        @Autowired
        private ClienteService ClienteService;

        // Para teste, depois retirar
        @GetMapping
        public static String hola() {
            return "Hola";
        }

        @PostMapping("/criarCliente")
        public Cliente criarcCliente(@RequestBody Cliente cliente) {
            return ClienteService.saveCliente(cliente);
        }

        @DeleteMapping("/deletar/{id}")
        public void deletarCliente(@RequestBody Cliente cliente) {
            ClienteService.deleteCliente(cliente);
        }
}
