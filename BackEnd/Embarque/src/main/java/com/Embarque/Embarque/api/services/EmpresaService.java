package com.Embarque.Embarque.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Embarque.Embarque.persistance.models.Empresa;
import com.Embarque.Embarque.persistance.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa saveEmpresa(Empresa empresa) {
        empresa.setSenha(passwordEncoder.encode(empresa.getSenha()));
        return empresaRepository.save(empresa);
    }

    public void deleteEmpresa(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        empresa.ifPresent(empresaRepository::delete);
    }

    public Empresa atualizarSenha(Empresa empresa, String senha) {
        empresa.setSenha(passwordEncoder.encode(senha));
        return empresaRepository.save(empresa);
    }

    public Iterable<Empresa> getAllEmpresa() {
        return empresaRepository.findAll();
    }
}
