package com.Embarque.Embarque.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Embarque.Embarque.api.services.ReservaAssentosService;
import com.Embarque.Embarque.persistance.models.Assento;

@RestController
@CrossOrigin("*")
@RequestMapping("/reservas")
public class ReservaAssentosController {

    @Autowired
    private ReservaAssentosService reservaAssentosService;

    @GetMapping("/{onibusId}/assentos/ver-disponiveis")
    public ResponseEntity<List<Assento>> verAssentosDisponiveis(@PathVariable Long onibusId) {
        List<Assento> assentosDisponiveis = reservaAssentosService.verAssentosDisponiveis(onibusId);
        return ResponseEntity.ok(assentosDisponiveis);
    }

    @PostMapping("/{onibusId}/assentos/{numeroAssento}/reservar")
    public ResponseEntity<String> reservarAssento(@PathVariable Long onibusId, @PathVariable int numeroAssento) {
        try {
            reservaAssentosService.reservarAssento(onibusId, numeroAssento);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{onibusId}/assentos/{numeroAssento}/cancelar")
    public ResponseEntity<String> cancelarReservaAssento(@PathVariable Long onibusId, @PathVariable int numeroAssento) {
        try {
            reservaAssentosService.cancelarReservaAssento(onibusId, numeroAssento);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}