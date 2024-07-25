# Star Management Application

## Overview

The Star Management Application is a Spring Boot-based REST API that allows users to manage information about stars. This project provides functionality to create, read, update, and delete star entries, as well as perform various queries on the stored data.

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.2**
- **Spring Data JPA**
- **Spring Web**
- **Springdoc OpenAPI**
- **Hibernate**
- **PostgreSQL**
- **Flyway**
- **Lombok**
- **Maven**

## Features

- **CRUD Operations**: Create, read, update, and delete star entries.
- **Distance Queries**: Retrieve closest stars, stars by distance, and unique stars by name.
- **Validation**: Ensures data integrity with validation rules.
- **Error Handling**: Global exception handling for consistent error responses.
- **API Documentation**: Interactive API documentation using Swagger.

## Getting Started

### Prerequisites

- **Java 17**: Ensure you have Java 17 installed.
- **PostgreSQL**: Ensure PostgreSQL is installed and running.
- **Maven**: Ensure Maven is installed.

### Installation

1. **Clone the Repository**:
   git clone https://github.com/piotrk32/Task.git
2. **Configure database. Example in application.yml**
3. **Build project**
4. **Run and test application in Swagger: http://localhost:8080/swagger-ui/index.html#/Star/createStar**
### Conclusion
There are many possibilities to make this application more optimal. One of them is the extension of validation, which is not perfect. Additionally, enhancing error handling, improving performance, and implementing security for example OAUTH2 measures are crucial. For further development, consider adding advanced validation, comprehensive error handling, and scalability improvements to ensure robustness and user satisfaction.
