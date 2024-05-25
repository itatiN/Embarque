package com.Embarque.Embarque.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Embarque.Embarque.persistance.models.Cliente;
import com.Embarque.Embarque.persistance.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private ClienteRepository clienteRepository; 

    public Cliente saveCliente(Cliente cliente) {
        cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
