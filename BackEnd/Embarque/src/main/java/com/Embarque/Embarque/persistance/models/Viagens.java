package com.Embarque.Embarque.persistance.models;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "viagens")
public class Viagens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
    @NotEmpty(message = "Valor obrigatorio")
    @Column(name = "preco", unique = false)
    private Float preco;

    @NotEmpty(message = "Origem obriagatorio")
    @Column(name = "origem", unique = false)
    private String origem;

    @NotEmpty(message = "Destino obrigatorio")
    @Column(name = "destino", unique = false)
    private String destino;

    @NotEmpty(message = "Data obrigatorio")
    @Column(name = "data", unique = false)
    private Data data;

    @NotEmpty(message = "Horario obrigatorio")
    @Column(name = "horario", unique = false)
    private Time horario;

    //falta fazer o Onibus iD FK
}
