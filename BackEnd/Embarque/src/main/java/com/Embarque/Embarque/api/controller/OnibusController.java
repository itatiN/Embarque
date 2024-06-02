package com.Embarque.Embarque.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Embarque.Embarque.api.services.OnibusService;
import com.Embarque.Embarque.persistance.models.Onibus;
import com.Embarque.Embarque.persistance.repositories.OnibusRepository;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/onibus")
public class OnibusController {

    @Autowired
    private OnibusService onibusService;

    @Autowired
    private OnibusRepository onibusRepository;

    @PostMapping("/criar-onibus")
    public ResponseEntity<Onibus> criarOnibus(@RequestBody Onibus onibus) {
        Onibus novoOnibus = onibusService.criarOnibus(onibus);
        return ResponseEntity.ok(novoOnibus);
    }

    @DeleteMapping("/{id}/remover-onibus")
    public ResponseEntity<Void> deleteOnibus(@PathVariable Long id) {
        Optional<Onibus> onibus = onibusRepository.findById(id);
        if (onibus.isPresent()) {
            onibusService.deleteOnibus(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/mudar-piloto")
    public ResponseEntity<Onibus> mudarPiloto(@PathVariable Long id, @RequestBody String novoPiloto) {
        Optional<Onibus> onibusOptional = onibusRepository.findById(id);
        if (onibusOptional.isPresent()) {
            Onibus onibus = onibusOptional.get();
            Onibus onibusAtualizado = onibusService.mudarPiloto(onibus, novoPiloto);
            return ResponseEntity.ok(onibusAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Onibus>> getAllOnibus() {
        Iterable<Onibus> onibusList = onibusService.getAllOnibus();
        return ResponseEntity.ok(onibusList);
    }
}
