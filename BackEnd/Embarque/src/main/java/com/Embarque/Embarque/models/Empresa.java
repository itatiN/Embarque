package com.Embarque.Embarque.models;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("empresa")
public class Empresa extends User{
    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;
}
