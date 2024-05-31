package com.Embarque.Embarque.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Embarque.Embarque.persistance.models.Viagens;
import com.Embarque.Embarque.persistance.repositories.ViagensRepository;

@Service
public class ViagensService {
    @Autowired
    private ViagensRepository viagensRepository;

    public Iterable<Viagens> getAllViagens(){
        return viagensRepository.findAll();
    }

    public Iterable<Viagens> getViagensByDestino(String destino){
        return viagensRepository.findByDestino(destino);
    }
    
    public Iterable<Viagens> getViagensByOrigemAndDestino(String origem, String destino) {
        return viagensRepository.findByOrigemAndDestino(origem, destino);
    }

    public Viagens criarViagem(Viagens viagem) {
        return viagensRepository.save(viagem);
    }

    public void removerViagem(Long id) {
        Optional<Viagens> viagem = viagensRepository.findById(id);
        viagem.ifPresent(viagensRepository::delete);
    }
}
