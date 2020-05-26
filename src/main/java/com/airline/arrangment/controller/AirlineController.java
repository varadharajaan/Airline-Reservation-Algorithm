package com.airline.arrangment.controller;

import com.airline.arrangment.service.AirlineService;
import com.airline.arrangment.model.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class AirlineController {


	AirlineService airlineService;

	@Autowired
	public void setAirlineService(AirlineService airlineService) {
		this.airlineService = airlineService;
	}

	@PostMapping("/airline-arrangement")
	public ResponseEntity<String> firstPage(@Valid  @RequestBody RequestDTO input) {
		return new ResponseEntity<>(airlineService.allocateSeats(input.getSeat(),input.getPassenger()), HttpStatus.CREATED);
	}

}
