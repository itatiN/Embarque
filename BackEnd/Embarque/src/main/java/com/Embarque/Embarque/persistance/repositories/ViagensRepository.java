package com.Embarque.Embarque.persistance.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Embarque.Embarque.persistance.models.Viagens;

@Repository
public interface ViagensRepository extends CrudRepository<Viagens, Integer>{

    Iterable<Viagens> findByDestino(String destino);
    
    Iterable<Viagens> findByOrigemAndDestino(String origem, String destino);

    Optional<Viagens> findById(Long id);
}
