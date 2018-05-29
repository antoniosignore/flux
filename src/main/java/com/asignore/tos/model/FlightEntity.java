package com.asignore.tos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AirportEntity sourceAirportEntity;

    @ManyToOne
    private AirportEntity destinationAirportEntity;

    @NotNull
    private Integer utcDepartureHour;

    @NotNull
    private Integer utcDepartureMinute;

    @NotNull
    private Integer durationMinutes;

}
