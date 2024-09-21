package com.jtrails.circuitbreaker.service;

import com.jtrails.circuitbreaker.model.TravelDestination;

/**
 * @author Lejil
 *
 */
public interface TravelDestinationService {

	TravelDestination getDestinationDetails(String destinationName,String country);
	
	String getAttractions(String destinationName,String country);
}
