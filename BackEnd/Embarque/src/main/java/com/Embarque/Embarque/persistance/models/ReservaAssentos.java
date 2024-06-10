package com.Embarque.Embarque.persistance.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reserva_assentos")
public class ReservaAssentos {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    private Onibus onibus;

    @ElementCollection
    private List<Assento> assentos;

    public List<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
    }
}
