package com.Embarque.Embarque.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.Embarque.Embarque.api.config.Security.TokenService;
import com.Embarque.Embarque.api.services.EmpresaService;
import com.Embarque.Embarque.persistance.models.Cliente;
import com.Embarque.Embarque.persistance.models.LoginRequestDTO;
import com.Embarque.Embarque.persistance.models.Empresa;
import com.Embarque.Embarque.persistance.models.ResponseDTO;
import com.Embarque.Embarque.persistance.repositories.EmpresaRepository;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/criar-empresa")
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
        Empresa savedEmpresa = empresaService.saveEmpresa(empresa);
        return ResponseEntity.ok(savedEmpresa);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()) {
            empresaService.deleteEmpresa(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/atualizar-senha/{id}")
    public ResponseEntity<Empresa> updateSenha(@PathVariable Long id, @RequestBody String novaSenha) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isPresent()) {
            Empresa empresa = empresaOptional.get();
            Empresa updatedEmpresa = empresaService.atualizarSenha(empresa, novaSenha);
            return ResponseEntity.ok(updatedEmpresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Empresa>> getAllEmpresas() {
        Iterable<Empresa> empresas = empresaService.getAllEmpresa();
        return ResponseEntity.ok(empresas);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body) {
        Empresa empresa = empresaRepository.findByEmail(body.email())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrado e azul"));
        if (passwordEncoder.matches(body.senha(), empresa.getSenha())) {
            String token = this.tokenService.generateTokenEmpresa(empresa);
            return ResponseEntity.ok(new ResponseDTO(empresa.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
