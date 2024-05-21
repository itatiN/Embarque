import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("empresa")
public class Empresa extends PermissaoEspecifica{
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;
}
