# Software Architecture Patterns and Demos with Spring

A collection of software architecture patterns and demos implemented using **Spring Boot**, **Spring Cloud**, **Spring Data**, and supporting technologies. The repository showcases core concepts of **software architecture** ranging from traditional client-server models to modern **microservices**, **event-driven systems**, and **cloud-native patterns**.

## Features

* **Client-Server and Layered Architectures**
* **Domain-Driven Design (DDD)**
* **Master-Slave and Component-based Architectures**
* **Service-Oriented Architecture (SOA)**
* **Event-Driven and Message Queue Integration**
* **Enterprise Service Bus (ESB)**
* **Microservices with Spring Cloud**
* **Pipe-and-Filter and Stream-based Processing**
* **Observability with Zipkin and Hystrix**
* **Spring Data JPA and MongoDB Demos**

## Modules

* **componentarcspringmongo** – Cart and product items with REST client integration
* **cqrs-and-central-configuration** – Spring Cloud Config with CQRS
* **diagrams** – Webshop design diagrams (component-based)
* **eureka-loadbalance-apigateway** – Eureka server, API Gateway, and load balancer
* **messagequeue** – Message queue based architecture and components
* **spring-cloud-contract** – Contract testing, Zipkin, and Hystrix for tracing & resilience
* **spring-jpa** – Student management demo with Spring JPA
* **springintegration-ecommerce** – Stock and product services integration via Spring Integration
* **springmongodemo** – MongoDB demo with Spring Data
* **zipkin-hystrix** – Distributed tracing and circuit breaker pattern with Zipkin & Hystrix

## Architecture Styles Covered

* Client-Server
* Layered Architecture
* Master-Slave
* Component-Based Design
* Service-Oriented Architecture (SOA)
* Enterprise Service Bus (ESB)
* Event-Driven Architecture (EDA)
* Microservices
* Hub-and-Spoke
* Blackboard Architecture
* Stream-based Processing
* Monolithic vs Distributed Systems

## Prerequisites

* **Java 17+**
* **Maven 3.8+**
* **Docker (optional, for containerized services)**

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/sunilpoudel123/software-architectures.git
   ```
2. Navigate into a specific module (e.g., `springintegration-ecommerce`):

   ```bash
   cd springintegration-ecommerce
   ```
3. Run the service:

   ```bash
   mvn spring-boot:run
   ```

## Diagrams

Architecture diagrams are available in the `diagrams/` folder.
