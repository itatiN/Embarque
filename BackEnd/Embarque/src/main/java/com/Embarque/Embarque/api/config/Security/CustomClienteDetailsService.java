package com.Embarque.Embarque.api.config.Security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.Embarque.Embarque.persistance.models.Cliente;
import com.Embarque.Embarque.persistance.repositories.ClienteRepository;

@Component
public class CustomClienteDetailsService  implements UserDetailsService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Cliente não encontrado e sopa de bolinhas"));
        return new org.springframework.security.core.userdetails.User(cliente.getEmail(), cliente.getSenha(), new ArrayList<>());
    }
    
}
