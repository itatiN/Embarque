package com.Embarque.Embarque.persistance.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Assento {
    private int numero;
    private boolean disponivel;

    public Assento(int numero, boolean disponivel) {
        this.numero = numero;
        this.disponivel = disponivel;
    }
}