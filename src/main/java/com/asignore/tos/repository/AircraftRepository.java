package com.asignore.tos.repository;

import com.asignore.tos.model.AircraftEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<AircraftEntity, Long> {

    public AircraftEntity findByRegistrationEquals(String registration);
}
