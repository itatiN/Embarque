package com.Embarque.Embarque.persistance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @NotEmpty(message = "Nome e Obrigatorio")
    @Column(name = "nome", unique = false)
    private String nome;  
    
    @Email
    @NotEmpty(message = "Email e Obrigatorio")
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Senha e Obrigatorio")
    @Size(min = 8, message = "Sua senha deve ter no minimo {min} caracteres")
    @Column(name = "senha", unique = true)
    private String senha;

    @NotEmpty(message = "CNPJ e Obrigatorio")
    @Size(min = 14, max = 14, message = "Seu CNPJ devera conter 14 caracteres")
    @Column(name = "cnpj", unique = true)
    private String cnpj;
}
