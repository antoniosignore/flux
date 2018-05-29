package com.asignore.tos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode
@ToString(callSuper = true, exclude = {"sourceAirportEntity", "destinationAirportEntity"})
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
