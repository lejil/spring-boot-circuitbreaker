package com.jtrails.circuitbreaker.model;

/**
 * @author Lejil
 *
 */

public class TravelDestination {

	private String destinationId;

	private String country;

	private String name;

	private String city;

	private String description;

	private String category;

	private String bestSeasonToVisit;

	private String attractions;

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBestSeasonToVisit() {
		return bestSeasonToVisit;
	}

	public void setBestSeasonToVisit(String bestSeasonToVisit) {
		this.bestSeasonToVisit = bestSeasonToVisit;
	}

	public String getAttractions() {
		return attractions;
	}

	public void setAttractions(String attractions) {
		this.attractions = attractions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}