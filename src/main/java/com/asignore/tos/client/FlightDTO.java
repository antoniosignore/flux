package com.asignore.tos.client;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightDTO {

    private String origin;
    private String destination;
    private String departure;
    private String arrival;
    private String equipment;

}
