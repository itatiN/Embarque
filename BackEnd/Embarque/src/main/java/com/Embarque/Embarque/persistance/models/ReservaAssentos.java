package com.Embarque.Embarque.persistance.models;

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
}
