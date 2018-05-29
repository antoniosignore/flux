package com.asignore.tos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@ToString(callSuper = true, exclude = "aircrafts")
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String code;

    @OneToMany(mappedBy = "airport", fetch = FetchType.EAGER)
    private List<AircraftEntity> aircrafts = new ArrayList<>();

}
