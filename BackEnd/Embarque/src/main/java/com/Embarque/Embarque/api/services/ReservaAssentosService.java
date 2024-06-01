package com.Embarque.Embarque.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Embarque.Embarque.persistance.models.ReservaAssentos;
import com.Embarque.Embarque.persistance.models.Assento;
import com.Embarque.Embarque.persistance.repositories.OnibusRepository;
import com.Embarque.Embarque.persistance.repositories.ReservaAssentosRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservaAssentosService {

    @Autowired
    private ReservaAssentosRepository reservaAssentosRepository;

    @Autowired
    private OnibusRepository onibusRepository;

    public List<Assento> verAssentosDisponiveis(Long onibusId) {
        Optional<ReservaAssentos> assentoOptional = reservaAssentosRepository.findById(onibusId);
        if (assentoOptional.isPresent()) {
            return assentoOptional.get().getAssentos().stream()
                    .filter(Assento::isDisponivel)
                    .collect(Collectors.toList());
        }
        throw new RuntimeException("Ônibus não encontrado com o ID: " + onibusId);
    }

    @Transactional
    public void reservarAssento(Long onibusId, int numeroAssento) {
        Optional<ReservaAssentos> assentoOptional = reservaAssentosRepository.findById(onibusId);
        if (assentoOptional.isPresent()) {
            ReservaAssentos reservaAssentos = assentoOptional.get();
            Assento assento = reservaAssentos.getAssentos().stream()
                    .filter(a -> a.getNumero() == numeroAssento)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Assento não encontrado: " + numeroAssento));
            
            if (!assento.isDisponivel()) {
                throw new RuntimeException("Assento já está reservado: " + numeroAssento);
            }
            
            assento.setDisponivel(false);
            reservaAssentosRepository.save(reservaAssentos);
        } else {
            throw new RuntimeException("Ônibus não encontrado com o ID: " + onibusId);
        }
    }
    
    @Transactional
    public void cancelarReservaAssento(Long onibusId, int numeroAssento) {
        Optional<ReservaAssentos> assentoOptional = reservaAssentosRepository.findById(onibusId);
        if (assentoOptional.isPresent()) {
            ReservaAssentos reservaAssentos = assentoOptional.get();
            Assento assento = reservaAssentos.getAssentos().stream()
                    .filter(a -> a.getNumero() == numeroAssento)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Assento não encontrado: " + numeroAssento));
            
            if (assento.isDisponivel()) {
                throw new RuntimeException("Assento já está disponível: " + numeroAssento);
            }
            
            assento.setDisponivel(true);
            reservaAssentosRepository.save(reservaAssentos);
        } else {
            throw new RuntimeException("Ônibus não encontrado com o ID: " + onibusId);
        }
    }
}