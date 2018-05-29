package com.asignore.tos.service;

import com.asignore.tos.model.AircraftEntity;
import com.asignore.tos.model.AirportEntity;
import com.asignore.tos.model.FlightEntity;
import com.asignore.tos.repository.AircraftRepository;
import com.asignore.tos.repository.AirportRepository;
import com.asignore.tos.repository.FlightRepository;
import org.springframework.stereotype.Service;


@Service
public class DatabaseTestHelper {

    final AirportRepository airportRepository;
    final AircraftRepository aircraftRepository;
    final FlightRepository flightRepository;

    public DatabaseTestHelper(AirportRepository airportRepository, AircraftRepository aircraftRepository, FlightRepository flightRepository) {
        this.airportRepository = airportRepository;
        this.aircraftRepository = aircraftRepository;
        this.flightRepository = flightRepository;
    }

    public void initDb() {
        AirportEntity london = new AirportEntity();
        london.setCity("London");
        london.setCode("LHR");
        airportRepository.save(london);

        AirportEntity berlin = new AirportEntity();
        berlin.setCity("Berlin");
        berlin.setCode("TXL");
        airportRepository.save(berlin);

        AirportEntity munich = new AirportEntity();
        munich.setCity("Munich");
        munich.setCode("MUC");
        airportRepository.save(munich);

        AirportEntity hamburg = new AirportEntity();
        hamburg.setCity("Hamburg");
        hamburg.setCode("HAM");
        airportRepository.save(hamburg);

        AircraftEntity aircraftEntity = new AircraftEntity();
        aircraftEntity.setMake("Boeing");
        aircraftEntity.setModel("737");
        aircraftEntity.setAirport(berlin);
        aircraftEntity.setRegistration("FL-0001");
        aircraftRepository.save(aircraftEntity);

        aircraftEntity = new AircraftEntity();
        aircraftEntity.setMake("Airbus");
        aircraftEntity.setModel("A321");
        aircraftEntity.setAirport(munich);
        aircraftEntity.setRegistration("FL-0002");
        aircraftRepository.save(aircraftEntity);

        aircraftEntity = new AircraftEntity();
        aircraftEntity.setMake("Boeing");
        aircraftEntity.setModel("747-400");
        aircraftEntity.setAirport(london);
        aircraftEntity.setRegistration("FL-0003");
        aircraftRepository.save(aircraftEntity);

        aircraftEntity = new AircraftEntity();
        aircraftEntity.setMake("Airbus");
        aircraftEntity.setModel("A320");
        aircraftEntity.setAirport(hamburg);
        aircraftEntity.setRegistration("FL-0004");
        aircraftRepository.save(aircraftEntity);

        saveFlight(berlin, munich, 10, 0, 60);
        saveFlight(berlin, munich, 15, 0, 60);
        saveFlight(berlin, munich, 16, 0, 60);
        saveFlight(berlin, munich, 18, 0, 60);
        saveFlight(berlin, hamburg, 21, 0, 40);

        saveFlight(munich, london, 10, 0, 120);
        saveFlight(munich, berlin, 15, 0, 60);
        saveFlight(munich, berlin, 16, 0, 60);
        saveFlight(munich, london, 18, 0, 120);
        saveFlight(munich, hamburg, 21, 0, 60);
        saveFlight(munich, london, 10, 0, 150);
        saveFlight(munich, london, 15, 0, 120);
        saveFlight(munich, berlin, 16, 0, 60);

        saveFlight(london, hamburg, 21, 0, 150);
        saveFlight(london, berlin, 10, 0, 120);
        saveFlight(london, berlin, 15, 0, 120);
        saveFlight(london, munich, 16, 0, 120);

        saveFlight(hamburg, hamburg, 10, 0, 60);
        saveFlight(hamburg, hamburg, 15, 0, 60);
        saveFlight(hamburg, hamburg, 16, 0, 60);
    }

    private void saveFlight(AirportEntity source, AirportEntity arrival, int hour, int minutes, int durationInMinutes) {
        FlightEntity flight = new FlightEntity();
        flight.setSourceAirportEntity(source);
        flight.setDestinationAirportEntity(arrival);
        flight.setUtcDepartureHour(hour);
        flight.setUtcDepartureMinute(minutes);
        flight.setDurationMinutes(durationInMinutes);
        flightRepository.save(flight);
    }
}
