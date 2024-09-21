# Resilience4j Circuit Breaker and Rate Limiter with Spring Boot

 * This project demonstrates how to implement Resilience4j's Circuit Breaker and Rate Limiter patterns in a Spring Boot application to build resilient microservices. The Circuit Breaker helps protect your services from cascading failures during downtime by stopping requests when a service is unhealthy, while the Rate Limiter limits the number of calls made to a service in a defined time window, preventing overloading and ensuring stability.

# Key Features:
* Circuit Breaker: Configurable failure threshold, retry interval, and recovery period.
* Rate Limiter: Dynamic control over the rate of requests to external services.
* Fully integrated with Spring Boot for seamless configuration and management.
* Fallback Mechanisms for graceful degradation when failures or limits are triggered.

# Tech Stack:
* Spring Boot 3.x
* Resilience4j 2.x
* Maven
* Java 17
* This repository includes sample code to get started quickly with resilient API integrations.
