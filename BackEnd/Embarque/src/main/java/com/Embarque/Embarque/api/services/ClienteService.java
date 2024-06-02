package com.Embarque.Embarque.api.services;

import java.util.Optional;

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
        cliente.setCpf(passwordEncoder.encode(cliente.getCpf()));
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        cliente.ifPresent(clienteRepository::delete);
    }

    public Cliente atualizarSenha(Cliente cliente, String senha) {
        cliente.setSenha(passwordEncoder.encode(senha));
        return clienteRepository.save(cliente);
    }

    public Iterable<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
}