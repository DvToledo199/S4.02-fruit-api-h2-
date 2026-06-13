

# Fruit API H2

REST API built with Spring Boot for managing fruit stock. This project implements a complete CRUD (Create, Read, Update, Delete) using an H2 in-memory database, DTOs, validation, global exception handling, automated tests, and Docker support.

## Features

- Create a fruit
- Get all fruits
- Get a fruit by ID
- Update a fruit
- Delete a fruit
- DTO-based API design
- Bean Validation (`@NotBlank`, `@Positive`)
- Global exception handling
- H2 database persistence with Spring Data JPA
- Unit tests with Mockito
- Controller tests with MockMvc
- Multi-stage Docker build

## Technologies

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database
- Bean Validation
- JUnit 5
- Mockito
- MockMvc
- Maven
- Docker

## Project Structure

```text
src
├── main
│   ├── controllers
│   ├── services
│   ├── repository
│   ├── model
│   └── exception
└── test
    ├── controllers
    └── services
```

## API Endpoints

| Method | Endpoint | Description |
|----------|----------|----------|
| POST | `/fruits` | Create a fruit |
| GET | `/fruits` | Get all fruits |
| GET | `/fruits/{id}` | Get a fruit by ID |
| PUT | `/fruits/{id}` | Update a fruit |
| DELETE | `/fruits/{id}` | Delete a fruit |

## Request Example

### Create Fruit

```json
{
  "name": "Apple",
  "weightInKilos": 10
}
```

## Response Codes

| Code | Meaning |
|------|---------|
| 200 OK | Successful GET or PUT request |
| 201 Created | Fruit created successfully |
| 204 No Content | Fruit deleted successfully |
| 400 Bad Request | Validation error |
| 404 Not Found | Fruit not found |

## Running the Application

### Using Maven

```bash
mvn spring-boot:run
```

### Running Tests

```bash
mvn test
```

## Docker

Build the Docker image:

```bash
docker build -t fruit-api-h2 .
```

Run the container:

```bash
docker run -p 8080:8080 fruit-api-h2
```

## Testing

The project includes:

- Unit tests for the service layer using Mockito
- Controller endpoint tests using MockMvc

## Author

Developed as part of the IT Academy Spring Boot training exercises.