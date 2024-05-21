package com.Embarque.Embarque.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Permissao {
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @JsonIgnore // Evita ciclo infinito na serialização JSON
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    @DiscriminatorColumn(name = "permissao_especifica_type")
    private PermissaoEspecifica permissaoEspecifica;
}
