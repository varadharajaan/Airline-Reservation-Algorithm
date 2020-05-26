package com.airline.arrangment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class AirlineController {


	AirlineUtils airlineUtils;

	@Autowired
	public void setAirlineUtils(AirlineUtils airlineUtils) {
		this.airlineUtils = airlineUtils;
	}

	@PostMapping("/airline-arrangement")
	public ResponseEntity<String> firstPage(@Valid  @RequestBody RequestDTO input) {
		return new ResponseEntity<>(airlineUtils.allocateSeats(input.getSeat(),input.getPassenger()), HttpStatus.CREATED);
	}

}
