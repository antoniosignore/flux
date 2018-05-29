package com.asignore.tos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String code;

    @OneToMany(mappedBy = "airport", fetch = FetchType.EAGER)
    private List<AircraftEntity> aircrafts = new ArrayList<>();

}
