# Getting Started

building a simple e-commerce application where customers can order products. Our application contains the following services:

* Product Service
* Order Service
* Inventory Service
* Notification Service


### Reference Documentation

For further reference, please consider the following sections:

* covers building REST-based applications using Spring Boot 3 and following several best practices.
* covers, the [Synchronous Inter-Service Communication Pattern](https://microservices.io/patterns/communication-style/rpi.html) using Spring Cloud Open Feign.
* covers the [Service Discovery Pattern](https://microservices.io/patterns/server-side-discovery.html) using Spring Cloud Netflix Eureka.
* covers the [Microservices Security](https://microservices.io/patterns/apigateway.html) using Keycloak.
* covers the [Circuit Breaker Pattern](https://microservices.io/patterns/reliability/circuit-breaker.html) using Spring Cloud CircuitBreaker with Resilience4J.
* covers the [Event Driven Architecture Pattern](https://microservices.io/patterns/data/event-driven-architecture.html) using Kafka
* containerizing all our applications using Docker.
* Prometheus to collect the Metrics and Grafana to visualize the metrics in a dashboard

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/#build-image)

* Keycloak
  Keycloak provides user federation, strong authentication, user management, fine-grained authorization, and more. Add authentication to applications and secure services with minimum effort. No need to deal with storing users or authenticating users.

* Circuit breaker:
  [Spring Cloud Circuit breaker provides an abstraction across different circuit breaker implementations. It provides a consistent API to use in your applications allowing you the developer to choose the circuit breaker implementation that best fits your needs for your app.](https://spring.io/projects/spring-cloud-circuitbreaker)

* Resilience4J
 [Resilience4j is a lightweight fault tolerance library designed for functional programming for more](https://resilience4j.readme.io/docs/getting-started)

* [Building Java containers with Jib: ](https://cloud.google.com/java/getting-started/jib)
  Jib builds containers without using a Dockerfile or requiring a Docker installation. You can use Jib in the Jib plugins for Maven or Gradle, or you can use the Jib Java library.
