package com.Embarque.Embarque.models;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("cliente")
public class Cliente extends User{
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    //resolver depois
    @Column(name = "data_nascimento", nullable = false, unique = false)
    private String dataNascimento;
}
