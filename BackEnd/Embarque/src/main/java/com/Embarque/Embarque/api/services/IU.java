package com.Embarque.Embarque.api.services;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Embarque.Embarque.models.User;

import java.util.Optional;

public interface IU extends CrudRepository<User, Integer>{

}