package com.Embarque.Embarque.models;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;


import lombok.Getter;
import lombok.Setter;


@Entity
@DiscriminatorValue("cliente")
public class Cliente extends Permissao{
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    //resolver depois
    @Column(name = "data_nascimento", nullable = false, unique = false)
    private String dataNascimento;
}
