package com.asignore.tos.service;

import com.asignore.tos.client.FlightDTO;
import com.asignore.tos.client.OperationsPlanDTO;
import com.asignore.tos.model.FlightEntity;
import com.asignore.tos.utils.DateFormatter;


public class Mapper {

    private static String toDate(Integer hour, Integer minute) {
        return DateFormatter.toDate(hour, minute);
    }

    public static FlightDTO toFlightDTO(FlightEntity flightEntity) {
        FlightDTO dto = new FlightDTO();
        dto.setOrigin(flightEntity.getSourceAirportEntity().getCode());
        dto.setDestination(flightEntity.getDestinationAirportEntity().getCode());
        dto.setDeparture(toDate(flightEntity.getUtcDepartureHour(), flightEntity.getUtcDepartureMinute()));
        dto.setArrival(toDate(flightEntity.getUtcDepartureHour(),
                flightEntity.getUtcDepartureMinute() + flightEntity.getDurationMinutes()));
        dto.setEquipment(flightEntity.getSourceAirportEntity().getAircrafts().get(0).getModel());
        return dto;
    }

    public static OperationsPlanDTO toOperationPlanDTO(FlightEntity flightEntity) {
        OperationsPlanDTO planDTO = new OperationsPlanDTO();
        planDTO.setOrigin(flightEntity.getSourceAirportEntity().getCode());
        planDTO.setDestination(flightEntity.getDestinationAirportEntity().getCode());
        planDTO.setDeparture(toDate(flightEntity.getUtcDepartureHour(), flightEntity.getUtcDepartureMinute()));
        return planDTO;
    }
}
