package com.Embarque.Embarque.persistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "onibus")
@SecondaryTable(name="reserva-de-assentos", pkJoinColumns=@PrimaryKeyJoinColumn(name="id"))
public class Onibus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 7, max = 7, message = "Devera colocar uma placa valida")
    @Column(name = "placa")
    private String placa;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "piloto")
    private String piloto;

    @Column(name = "numero-de-assentos")
    private int numeroAssentos;
    
}
