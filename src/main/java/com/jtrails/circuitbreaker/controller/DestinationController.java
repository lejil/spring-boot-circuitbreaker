package com.jtrails.circuitbreaker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtrails.circuitbreaker.model.TravelDestination;
import com.jtrails.circuitbreaker.service.TravelDestinationService;

/**
 * @author Lejil
 *
 */
@RestController
public class DestinationController {

	private final TravelDestinationService travelDestinationService;
	
	DestinationController(TravelDestinationService travelDestinationService){
		this.travelDestinationService = travelDestinationService;
	}
	
	
	//Rest API to test circuit breaker
	@GetMapping("/travelDestination")
	public ResponseEntity<TravelDestination>  getDestinationDetails(String location,String country){
		TravelDestination travelDestination = travelDestinationService.getDestinationDetails(location,country);
		return new ResponseEntity<>(travelDestination, HttpStatus.OK);
	}
	
	//Rest API to test Rate limit
	@GetMapping("/travelAttractions")
	public ResponseEntity<String>  getAttractions(String location,String country){
		String attractions = travelDestinationService.getAttractions(location,country);
		return new ResponseEntity<>(attractions, HttpStatus.OK);
	}
}
