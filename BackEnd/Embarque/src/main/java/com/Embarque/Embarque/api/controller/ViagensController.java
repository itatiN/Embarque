package com.Embarque.Embarque.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Embarque.Embarque.api.services.ViagensService;
import com.Embarque.Embarque.persistance.models.Viagens;
import com.Embarque.Embarque.persistance.repositories.ViagensRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/viagens")
public class ViagensController {

    @Autowired
    private ViagensService viagensService;

    @Autowired
    private ViagensRepository viagensRepository;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Viagens>> getAllViagens() {
        Iterable<Viagens> viagens = viagensService.getAllViagens();
        return ResponseEntity.ok(viagens);
    }

    @GetMapping("/destino")
    public ResponseEntity<Iterable<Viagens>> getViagensByDestino(@RequestParam String destino) {
        Iterable<Viagens> viagens = viagensService.getViagensByDestino(destino);
        return ResponseEntity.ok(viagens);
    }

    @GetMapping("/origem-destino")
    public ResponseEntity<Iterable<Viagens>> getViagensByOrigemAndDestino(@RequestParam String origem, @RequestParam String destino) {
        Iterable<Viagens> viagens = viagensService.getViagensByOrigemAndDestino(origem, destino);
        return ResponseEntity.ok(viagens);
    }

    @PostMapping("/criar-viagem")
    public ResponseEntity<Viagens> criarViagem(@RequestBody Viagens viagem) {
        Viagens novaViagem = viagensService.criarViagem(viagem);
        return ResponseEntity.ok(novaViagem);
    }

    @DeleteMapping("/{id}/remover-viagem")
    public ResponseEntity<Void> removerViagem(@PathVariable Long id) {
        Optional<Viagens> viagem = viagensRepository.findById(id);
        if (viagem.isPresent()) {
            viagensService.removerViagem(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}