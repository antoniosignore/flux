package com.asignore.tos.service;

import com.asignore.tos.client.FlightDTO;
import com.asignore.tos.client.OperationsPlanDTO;
import com.asignore.tos.model.AircraftEntity;
import com.asignore.tos.model.AirportEntity;
import com.asignore.tos.model.FlightEntity;
import com.asignore.tos.repository.AircraftRepository;
import com.asignore.tos.repository.AirportRepository;
import com.asignore.tos.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FluxService {

    final AirportRepository airportRepository;
    final AircraftRepository aircraftRepository;
    final FlightRepository flightRepository;

    public FluxService(AirportRepository airportRepository, AircraftRepository aircraftRepository, FlightRepository flightRepository) {
        this.airportRepository = airportRepository;
        this.aircraftRepository = aircraftRepository;
        this.flightRepository = flightRepository;
    }

    public Collection<FlightDTO> findByAirport(String airport) {
        final AirportEntity byCodeEquals = airportRepository.findByCodeEquals(airport);
        final List<FlightEntity> all = flightRepository.findAllBySourceAirportEntityEquals(byCodeEquals);
        return all.stream().map(Mapper::toFlightDTO).collect(Collectors.toList());
    }

    public Collection<OperationsPlanDTO> findByRegistration(String registration) {
        log.debug("FluxService.findByRegistration");
        AircraftEntity aircraftEntity = aircraftRepository.findByRegistrationEquals(registration);
        final AirportEntity airport = aircraftEntity.getAirport();
        final List<FlightEntity> all = flightRepository.findAllBySourceAirportEntityEquals(airport);
        List<OperationsPlanDTO> list = new ArrayList<>();
        for (FlightEntity flightEntity : all) {
            OperationsPlanDTO operationsPlanDTO = Mapper.toOperationPlanDTO(flightEntity);
            list.add(operationsPlanDTO);
        }
        return list;
    }

    public Collection<FlightDTO> findByAirport() {
        final List<FlightEntity> all = flightRepository.findAll();
        return all.stream().map(Mapper::toFlightDTO).collect(Collectors.toList());
    }

}

