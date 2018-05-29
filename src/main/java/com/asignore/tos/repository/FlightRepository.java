package com.asignore.tos.repository;

import com.asignore.tos.model.AirportEntity;
import com.asignore.tos.model.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    public List<FlightEntity> findAllBySourceAirportEntityEquals(AirportEntity airportEntity);

}
