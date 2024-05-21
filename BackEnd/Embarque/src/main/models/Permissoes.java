import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "permissoes")
public class Permissoes {
    @Id
    @GeneratedValue(strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    // a anotação OneToOne junto com a anotação JoinColumn indica que o atributo user é uma chave estrangeira
    @OneToOne 
    @JoinColumn(name = "fk_userId", nullable=false)
    private User fk_userId;

    @Column(name = "permissao", nullable=false)
    private String permissao;
}
