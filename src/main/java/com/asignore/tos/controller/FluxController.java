package com.asignore.tos.controller;

import com.asignore.tos.client.FlightDTO;
import com.asignore.tos.client.OperationsPlanDTO;
import com.asignore.tos.service.FluxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Optional;

@Slf4j
@RestController
public class FluxController implements FluxApi {

    private final FluxService fluxService;

    public FluxController(FluxService fluxService) {
        this.fluxService = fluxService;
    }

    @Override
    public Collection<FlightDTO> findByAirport(Optional<String> airport) {
        if (airport.isPresent())
            return this.fluxService.findByAirport(airport.get());
        else
            return this.fluxService.findByAirport();
    }

    @Override
    public Collection<OperationsPlanDTO> findByRegistration(@NotNull String registration) {
        return this.fluxService.findByRegistration(registration);
    }
}

