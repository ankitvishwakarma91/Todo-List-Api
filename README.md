# Todo List RestApi Using Spring Boot 
This is a Todo List REST API built with Spring Boot. It allows users to create an account, manage their todos, and perform CRUD operations on their tasks.

Features

User authentication and account creation

Create, read, update, and delete todo items

Secure endpoints with authentication

Tech Stack

Spring Boot (Backend Framework)

Spring Security (Authentication & Authorization)

Spring Data JPA (Database ORM)

H2 / MySQL (Database)

JWT (Authentication)

Getting Started

Prerequisites

Ensure you have the following installed:

Java 17+

Maven 3.6+

PostgreSQL/MySQL (or use H2 for in-memory DB)

Installation & Running

1. Clone the repository

 git clone [https://github.com/ankitvishwakarma91/todo-list-api.git](https://github.com/ankitvishwakarma91/Todo-List-Api.git
)
 cd todo-list-api

2. Configure database

Modify application.properties or application.yml (for MySQL or PostgreSQL):

spring.datasource.url=jdbc:mysql://localhost:3306/tododb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

For in-memory H2 database, use:

spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true

3. Build & Run

mvn clean install
mvn spring-boot:run

The application will start at http://localhost:8080

API Endpoints

1. User Registration

Endpoint: POST /api/auth/register

{
  "email": "john@example.com",
  "password": "password123"
}

Response:

{
  "message": "User registered successfully!"
}

2. User Login

Endpoint: POST /api/auth/login

{
  "username": "john_doe",
  "password": "password123"
}

Response:

{
  "token": "your-jwt-token"
}

Use the received JWT token in the Authorization header for protected endpoints:

Authorization: Bearer your-jwt-token

3. Create a Todo

Endpoint: POST /api/todo/add
Headers: Authorization: Bearer your-jwt-token

{
  "title": "Buy groceries",
  "description": "Milk, Bread, Eggs",
  "completed": false
}

4. Get All Todos

Endpoint: GET /api/todo
Headers: Authorization: Bearer your-jwt-token

5. Update a Todo

Endpoint: PUT /api/todo/update/{id}
Headers: Authorization: Bearer your-jwt-token

{
  "title": "Buy groceries",
  "description": "Milk, Bread, Eggs, Butter",
  "completed": true
}

6. Delete a Todo

Endpoint: DELETE /api/todo/delete/{id}
Headers: Authorization: Bearer your-jwt-token

Testing the API

You can test the API using:

Postman

cURL

Swagger UI (if configured)

Contributing

Feel free to contribute by submitting issues or pull requests.

License

This project is licensed under the MIT License.
