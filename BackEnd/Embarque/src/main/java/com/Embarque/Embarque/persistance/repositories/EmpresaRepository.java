package com.Embarque.Embarque.persistance.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Embarque.Embarque.persistance.models.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
    Optional<Empresa> findById(Long id);

    Optional<Empresa> findByEmail(String email);
}
