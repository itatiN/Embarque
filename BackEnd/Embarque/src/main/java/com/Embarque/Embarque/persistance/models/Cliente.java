package com.Embarque.Embarque.persistance.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome é obrigatório")
    @Column(name = "nome", unique = false)
    private String nome;

    @NotEmpty(message = "Email é obrigatório e deve ser válido")
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty
    @Size(min = 8, message = "Sua senha deve ter no mínimo {min} caracteres")
    @Column(name = "senha", unique = false)
    private String senha;

    @NotEmpty
    @Size(min = 11, max = 11, message = "Seu CPF deve ter 11 caracteres")
    @Column(name = "cpf", unique = true)
    private String cpf;

    @NotEmpty(message = "Data de Nascimento é obrigatória")
    @Column(name = "data-nascimento", unique = false)
    private Date dataNascimento;
}
