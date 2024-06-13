package com.Embarque.Embarque.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Embarque.Embarque.persistance.models.Assento;
import com.Embarque.Embarque.persistance.models.Onibus;
import com.Embarque.Embarque.persistance.models.ReservaAssentos;
import com.Embarque.Embarque.persistance.repositories.OnibusRepository;
import com.Embarque.Embarque.persistance.repositories.ReservaAssentosRepository;

import jakarta.transaction.Transactional;

@Service
public class OnibusService {
    @Autowired
    private OnibusRepository onibusRepository;

    @Autowired
    private ReservaAssentosRepository reservaAssentosRepository;
    
    @Transactional
    public Onibus criarOnibus(Onibus onibus) {
        Optional<Onibus> existingOnibus = onibusRepository.findByPlaca(onibus.getPlaca());
        if (existingOnibus.isPresent()) {
            throw new RuntimeException("Já existe um ônibus cadastrado com a placa " + onibus.getPlaca());
        }

        Onibus savedOnibus = onibusRepository.save(onibus);

        ReservaAssentos reservaAssentos = new ReservaAssentos();
        reservaAssentos.setOnibus(savedOnibus);
        
        List<Assento> assentos = new ArrayList<>();
        for (int i = 1; i <= onibus.getNumeroAssentos(); i++) {
            assentos.add(new Assento(i, true));
        }
        reservaAssentos.setAssentos(assentos);
        
        reservaAssentosRepository.save(reservaAssentos);
        
        return savedOnibus;
    }

    public void deleteOnibus(Long id) {
        Optional<Onibus> onibus = onibusRepository.findById(id);
        onibus.ifPresent(onibusRepository::delete);
    }

    public Onibus mudarPiloto(Onibus onibus, String novoPiloto) {
        onibus.setPiloto(novoPiloto);
        return onibusRepository.save(onibus);
    }

    public Iterable<Onibus> getAllOnibus() {
        return onibusRepository.findAll();
    }
}
