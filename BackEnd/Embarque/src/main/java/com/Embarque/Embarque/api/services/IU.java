package com.Embarque.Embarque.api.services;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Embarque.Embarque.models.User;

import java.util.Optional;

public interface IU extends CrudRepository<User, Integer>{
    @Query("SELECT u FROM Usuario u WHERE u.Email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM Usuario u WHERE u.Email = :email AND u.Password = :password")
    Optional<User> authenticatedUser(@Param("email") String email, @Param("password") String password);

}