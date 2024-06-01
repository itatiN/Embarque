package com.Embarque.Embarque.persistance.models;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Valor é obrigatorio")
    @Column(name = "preco", unique = false)
    private Float preco;

    @NotEmpty(message = "Origem é obriagatorio")
    @Column(name = "origem", unique = false)
    private String origem;

    @NotEmpty(message = "Destino é obrigatorio")
    @Column(name = "destino", unique = false)
    private String destino;

    @NotEmpty(message = "Data é obrigatorio")
    @Column(name = "data", unique = false)
    private Date data;

    @NotEmpty(message = "Horario é obrigatorio")
    @Column(name = "horario", unique = false)
    private Time horario;

    @ManyToOne
    private Onibus onibus;
}
