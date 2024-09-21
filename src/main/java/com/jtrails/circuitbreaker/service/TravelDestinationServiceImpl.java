package com.jtrails.circuitbreaker.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jtrails.circuitbreaker.model.TravelDestination;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.PostConstruct;

/**
 * @author Lejil
 *
 */

@Service
public class TravelDestinationServiceImpl implements TravelDestinationService {

	private static final String NO_DETAILS_AVAILABLE = "No Details Available";

	private final WebClient webClient;

	private final RateLimiterRegistry rateLimiterRegistry;

	TravelDestinationServiceImpl(WebClient webClient, RateLimiterRegistry rateLimiterRegistry) {
		this.webClient = webClient;
		this.rateLimiterRegistry = rateLimiterRegistry;
	}

	@Override
	@CircuitBreaker(name = "travelDestination", fallbackMethod = "fallbackTravelDestination")
	public TravelDestination getDestinationDetails(String destinationName, String country) {
		return webClient.get().uri("/travelDestination?" + "destinationId=" + destinationName + "&country=" + country)
				.retrieve().bodyToMono(TravelDestination.class).block();

	}

	public TravelDestination fallbackTravelDestination(String destinationName, String country, Exception ex) {
		TravelDestination destination = new TravelDestination();
		destination.setName(destinationName);
		destination.setCountry(country);
		destination.setAttractions(NO_DETAILS_AVAILABLE);
		destination.setDestinationId(NO_DETAILS_AVAILABLE);
		destination.setCity(NO_DETAILS_AVAILABLE);
		destination.setAttractions(country);
		return destination;
	}

	@Override
	@RateLimiter(name = "travelAttractions", fallbackMethod = "fallbackRateLimit")
	public String getAttractions(String destinationName, String country) {
		return "Stunning alpine scenery, wildlife viewing, and iconic trails like Trail Ridge Road and Bear Lake.";
	}

	public String fallbackRateLimit(String destinationName, String country, RequestNotPermitted requestNotPermitted) {
		return "API rate limit exceeded. Please try again in one minute.";
	}

	
	@PostConstruct
	public void postConstruct() {
		io.github.resilience4j.ratelimiter.RateLimiter.EventPublisher eventPublisher = rateLimiterRegistry
				.rateLimiter("travelAttractions").getEventPublisher();

		eventPublisher.onEvent(event -> System.out.println("travelAttractions- On Event. Event Details: " + event));
		eventPublisher.onSuccess(event -> System.out.println("travelAttractions - On Success. Event Details: " + event));
		eventPublisher.onFailure(event -> System.out.println("travelAttractions - On Failure. Event Details: " + event));

	}

}
