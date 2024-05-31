package com.Embarque.Embarque.persistance.repositories;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Embarque.Embarque.persistance.models.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
    Optional<Cliente> findById(Long id);
}