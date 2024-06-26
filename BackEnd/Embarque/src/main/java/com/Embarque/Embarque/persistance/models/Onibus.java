package com.Embarque.Embarque.persistance.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "onibus")
public class Onibus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    @Size(min = 7, max = 7, message = "Deverá colocar uma placa válida")
    @Column(name = "placa", unique = true)
    private String placa;

    @NotEmpty(message = "Modelo é obrigatório")
    @Column(name = "modelo", unique = false)
    private String modelo;

    @NotEmpty(message = "Piloto é obrigatório")
    @Column(name = "piloto", unique = false)
    private String piloto;

    @NotEmpty(message = "Numero de assentos é obrigatório")
    @Column(name = "numero-de-assentos")
    private int numeroAssentos;
}
