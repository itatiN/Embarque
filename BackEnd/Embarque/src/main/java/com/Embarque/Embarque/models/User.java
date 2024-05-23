package com.Embarque.Embarque.models;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user", discriminatorType = DiscriminatorType.STRING)
// Aconselho sempre nomear as tabelas em minusculo
// Isso faz ocupar menos memoria e gasta menos energia
// É pouco o que salvamos de energia, mas é algo.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", columnDefinition = "BINARY(16)")
    private Integer id;
    // Preferi escolher a definicao de coluna para o tipo BINARY(16)
    // pois isso minimiza o espaco(menos bytes e sem caracteres especiais)

    @Column(name = "nome", nullable = false, unique = false)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false, unique = false)
    private String senha;
}