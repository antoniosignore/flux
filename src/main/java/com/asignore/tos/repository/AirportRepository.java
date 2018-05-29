package com.asignore.tos.repository;

import com.asignore.tos.model.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<AirportEntity, Long> {

    public AirportEntity findByCodeEquals(String code);
}
