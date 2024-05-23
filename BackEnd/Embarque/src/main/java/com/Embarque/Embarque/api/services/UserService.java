package com.Embarque.Embarque.api.services;

import com.Embarque.Embarque.api.repositories.EmpresaRepository;
import com.Embarque.Embarque.api.repositories.ClienteRepository;
import com.Embarque.Embarque.models.Empresa;
import com.Embarque.Embarque.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Empresa saveEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
}
