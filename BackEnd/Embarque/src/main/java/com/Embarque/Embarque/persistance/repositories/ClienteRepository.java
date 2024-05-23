package com.Embarque.Embarque.persistance.repositories;
import org.springframework.data.repository.CrudRepository;

import com.Embarque.Embarque.persistance.models.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
    
}