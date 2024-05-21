import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
@SecondaryTable(name = "permissao", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
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

    @Column(name = "nome", nullable = false, unique = false)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false, unique = false)
    private String senha;
}