package com.Embarque.Embarque.api.repositories;
import org.springframework.data.repository.CrudRepository;
import com.Embarque.Embarque.models.User;

public interface ClienteRepository extends CrudRepository<User, Integer>{

}