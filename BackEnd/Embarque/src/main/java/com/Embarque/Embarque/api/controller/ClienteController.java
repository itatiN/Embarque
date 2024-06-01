package com.Embarque.Embarque.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Embarque.Embarque.api.services.ClienteService;
import com.Embarque.Embarque.persistance.models.Cliente;
import com.Embarque.Embarque.persistance.repositories.ClienteRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {
   
        @Autowired
        private ClienteService clienteService;

        @Autowired
        private ClienteRepository clienteRepository;

        @PostMapping("/criarCliente")
        public ResponseEntity<Cliente> criarcCliente(@RequestBody Cliente cliente) {
            clienteService.saveCliente(cliente);
            return ResponseEntity.ok(cliente);
        }

        @DeleteMapping("/deletar/{id}")
        public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
            Optional<Cliente> cliente = clienteRepository.findById(id);
            if (cliente.isPresent()) {
                clienteService.deleteCliente(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PutMapping("/atualizarSenha/{id}")
        public ResponseEntity<Cliente> atualizarSenha(@PathVariable Long id, @RequestBody String novaSenha) {
            Optional<Cliente> clienteOptional = clienteRepository.findById(id);
            if (clienteOptional.isPresent()) {
                Cliente cliente = clienteOptional.get();
                Cliente updatedCliente = clienteService.atualizarSenha(cliente, novaSenha);
                return ResponseEntity.ok(updatedCliente);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/all")
        public ResponseEntity<Iterable<Cliente>> getAllClientes() {
            Iterable<Cliente> clientes = clienteService.getAllClientes();
            return ResponseEntity.ok(clientes);
        }
}
