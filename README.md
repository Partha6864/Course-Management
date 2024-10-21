# Course Management API

- This project is a simple Course Management API built using Spring Boot,Hibernate and H2 Database.
- It provides basic CRUD operations for managing courses,including adding,retrieving,updating and deleting course information.
- The project is documented using Swagger UI.

## Features

- Add a new course
- Retrieve all courses
- Retrieve a course by ID
- Update a course
- Delete a course
- Interactive API documentation using Swagger

## Technologies Used

- **Java 21**
- **Spring Boot 3.3.4**
- **Hibernate**
- **H2 Database (in-memory)**
- **Lombok**
- **Springdoc OpenAPI (Swagger integration)**

## Requirements

- Java 21
- Maven

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/course-management-api.git
```

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

### 4. Accessing H2 Database Console

```bash
http://localhost:8080/h2-console
```

### 5. Accessing Swagger UI

```bash
http://localhost:8080/swagger-ui.html
