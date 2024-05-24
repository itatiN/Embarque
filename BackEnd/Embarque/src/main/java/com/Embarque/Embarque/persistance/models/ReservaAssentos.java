package com.Embarque.Embarque.persistance.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ReservaAssentos {
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Onibus id;
}
