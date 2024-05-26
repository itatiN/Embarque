package com.Embarque.Embarque.persistance.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Embarque.Embarque.persistance.models.Viagens;

@Repository
public interface ViagensRepository extends CrudRepository<Viagens, Integer>{
    
}
