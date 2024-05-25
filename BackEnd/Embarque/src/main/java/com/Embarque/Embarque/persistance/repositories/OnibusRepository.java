package com.Embarque.Embarque.persistance.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Embarque.Embarque.persistance.models.Onibus;

@Repository
public interface OnibusRepository extends CrudRepository<Onibus, Integer>{
    
}
