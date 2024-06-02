# Getting Started
### Services are build:
* Product-Service: Create and View Products, acts as Product catalog.
* Order-Service: Can order products.
* Inventory-Service: can check if product is available in stock or not.
* Notification-Service: Can send notifications, if order is placed.
* All the above services are going to interact with each other as Synchronous and Asynchronously.



### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/#build-image)
* [Flyway](https://www.red-gate.com/products/flyway/) Automate database deployments across teams and technologies.
* [RestClient](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-http-interface%5BSpring) is a synchronous HTTP client that offers a modern, fluent API. It offers an abstraction over HTTP libraries that allows for convenient conversion from a Java object to an HTTP request, and the creation of objects from an HTTP response.
* [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway) aims to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.
  * [Functional Endpoints](https://docs.spring.io/spring-framework/reference/web/webflux-functional.html) : Spring WebFlux includes WebFlux.fn, a lightweight functional programming model in which functions are used to route and handle requests and contracts are designed for immutability. It is an alternative to the annotation-based programming model but otherwise runs on the same Reactive Core foundation.
* [Keycloak](https://www.keycloak.org/)
   provides user federation, strong authentication, user management, fine-grained authorization, and more. Add authentication to applications and secure services with minimum effort. No need to deal with storing users or authenticating users.
* [springdoc-openapi](https://springdoc.org/) java library helps to automate the generation of API documentation using spring boot projects. springdoc-openapi works by examining an application at runtime to infer API semantics based on spring configurations, class structure and various annotations.

* [Circuit breaker](https://spring.io/projects/spring-cloud-circuitbreaker):
  Spring Cloud Circuit breaker provides an abstraction across different circuit breaker implementations. It provides a consistent API to use in your applications allowing you the developer to choose the circuit breaker implementation that best fits your needs for your app.

* [Resilience4J](https://resilience4j.readme.io/docs/getting-started)
  is a lightweight fault tolerance library designed for functional programming for more

* [Building Java containers with Jib: ](https://cloud.google.com/java/getting-started/jib)
  Jib builds containers without using a Dockerfile or requiring a Docker installation. You can use Jib in the Jib plugins for Maven or Gradle, or you can use the Jib Java library.