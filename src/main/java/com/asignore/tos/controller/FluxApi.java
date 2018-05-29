package com.asignore.tos.controller;

import com.asignore.tos.client.FlightDTO;
import com.asignore.tos.client.OperationsPlanDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/")
@Api(value = "flux api", tags = {"FLUX API"})
public interface FluxApi {

    // Swagger info section-------------------------------------------------
    @ApiOperation(value = "Get flightplan per airport", response = FlightDTO.class, responseContainer = "List", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved a flight plan", response = FlightDTO.class, responseContainer = "List")})
    // Swagger info section-------------------------------------------------
    @RequestMapping(value = "/flightplan",
            produces = {"application/hal+json", "application/problem+json", "application/json"},
            method = RequestMethod.GET)
    Collection<FlightDTO> findByAirport(@RequestParam(value = "airport") Optional<String> airport);

    // Swagger info section-------------------------------------------------
    @ApiOperation(value = "Get operating instructions", response = OperationsPlanDTO.class, responseContainer = "List", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an operational plan", response = OperationsPlanDTO.class, responseContainer = "List")})
    // Swagger info section-------------------------------------------------
    @RequestMapping(value = "//operationsplan",
            produces = {"application/hal+json", "application/problem+json", "application/json"},
            method = RequestMethod.GET)
    Collection<OperationsPlanDTO> findByRegistration(@RequestParam(value = "registration", required = true) @NotNull String registration);


}
