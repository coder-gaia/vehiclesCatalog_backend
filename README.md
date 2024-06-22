# Vehicle Catalog Project

Welcome to the Vehicle Catalog project! This repository contains microservices for managing vehicles and users, along with a configuration server.

## Microservices Overview

### Vehicle Service

The Vehicle Service manages vehicle-related data and functionalities.

#### Configuration

- **Application Properties:**
  ```properties
  spring.application.name=vehicle-service
  spring.data.mongodb.uri=mongodb://localhost:27017/vehicle_DB
  spring.config.import=configserver:
  springdoc.api-docs.path=/api-docs
  springdoc.swagger-ui.path=/swagger-ui.html
  
## User Service
The User Service handles user data and authentication.

## Configuration
Application Properties:
properties
Copy code
spring.application.name=user-service
spring.data.mongodb.uri=mongodb://localhost:27017/user_DB
spring.config.import=configserver:
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
token.jwt.secret.key=alexandreG-secret-key
token.jwt.issuer=gaiaAlexandre-issuer
spring.cloud.compatibility-verifier.enabled=false
Config Server
The Config Server centralizes configuration management for microservices.

## Configuration
Application Properties:

server.port=8888
spring.application.name=config-server
spring.profiles.active=native
spring.cloud.config.server.native.search-locations=classpath:/config
spring.security.user.name=root
spring.security.user.password=root
Configurations in config/
user-service.yml:

yaml
Copy code
server:
  port: 8081
  wait-time-in-ms-when-sync-empty: 3000

spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/user_DB
      auto-index-creation: true

application-version: 1.0
vehicle-service.yml:

yaml
Copy code
server:
  port: 8082
  wait-time-in-ms-when-sync-empty: 3000

spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      database: vehicle_DB
      auto-index-creation: true

application-version: 1.1


## Setup Instructions
To set up this project locally, follow these steps:

## Clone the Repository:


git clone <repository_url>
cd VehicleCatalog
Build and Run Each Microservice:

Vehicle Service:

cd VehicleService
mvn spring-boot:run
User Service:

cd UserService
mvn spring-boot:run
Config Server:

cd ConfigServer
mvn spring-boot:run
Access Microservices:

Vehicle Service: http://localhost:8082/swagger-ui.html
User Service: http://localhost:8081/swagger-ui.html(atualmente não está funcionando)
Config Server: http://localhost:8888
Contributing
Contributions are welcome! Follow these steps to contribute:

## Fork the repository.
Create a new branch (git checkout -b feature/new-feature).
Make your changes.
Commit your changes (git commit -am 'Add new feature').
Push to the branch (git push origin feature/new-feature).
Create a new Pull Request.

## License

Este conteúdo abrange todos os aspectos dos microservices (Vehicle Service, User Service) e do Config Server, juntamente com instruções de configuração e setup para facilitar o desenvolvimento e colaboração no projeto.

