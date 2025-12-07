package br.edu.ifpr.cars.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class TravelRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String origem;

    @NotNull
    String destino;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    Driver driver = null;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    @NotNull(message = "Passageiro é obrigatório")
    Passenger passenger;

    TravelRequestStatus status = TravelRequestStatus.CREATED;

}
