import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
// Aconselho sempre nomear as tabelas em minusculo
// Isso faz ocupar menos memoria e gasta menos energia
// É pouco o que salvamos de energia, mas é algo.
public class User {
    @Id
    @GeneratedValue(strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    // Preferi escolher a definicao de coluna para o tipo BINARY(16)
    // pois isso minimiza o espaco(menos bytes e sem caracteres especiais)

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;
}