package com.asignore.tos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true, exclude = "airport")
@EqualsAndHashCode
public class AircraftEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private String registration;

    @ManyToOne
    private AirportEntity airport;

}
