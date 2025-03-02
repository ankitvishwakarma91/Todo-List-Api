# Todo List RestApi Using Spring Boot 
This is a **Todo List REST API** built with **Spring Boot**. It allows users to create an account, manage their todos, and perform CRUD operations on their tasks.

---

## ✨ Features
- ✅ User authentication and account creation  
- ✅ Create, read, update, and delete todo items  
- ✅ Secure endpoints with authentication  

---

## 🛠 Tech Stack
- ☕ **Spring Boot** (Backend Framework)  
- 🔒 **Spring Security** (Authentication & Authorization)  
- 🗄 **Spring Data JPA** (Database ORM)  
- 💾 **H2 / MySQL** (Database)  
- 🔑 **JWT** (Authentication)  

---

## 🚀 Getting Started

### 📌 Prerequisites  
Ensure you have the following installed:  
- **Java 17+**  
- **Maven 3.6+**  
- **PostgreSQL/MySQL** (or use H2 for in-memory DB)  

---

### 🔧 Installation & Running

#### 1️⃣ Clone the repository  
```sh
git clone https://github.com/ankitvishwakarma91/todo-list-api.git
cd todo-list-api
2️⃣ Configure database
Modify application.properties or application.yml (for MySQL or PostgreSQL):

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/tododb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
For in-memory H2 database, use:

properties
Copy
Edit
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
3️⃣ Build & Run
sh
Copy
Edit
mvn clean install
mvn spring-boot:run
The application will start at: http://localhost:8080

📌 API Endpoints
🔹 1. User Registration
📍 Endpoint: POST /api/auth/register

📤 Request Body:
json
Copy
Edit
{
  "email": "john@example.com",
  "password": "password123"
}
📥 Response:
json
Copy
Edit
{
  "message": "User registered successfully!"
}
🔹 2. User Login
📍 Endpoint: POST /api/auth/login

📤 Request Body:
json
Copy
Edit
{
  "username": "john_doe",
  "password": "password123"
}
📥 Response:
json
Copy
Edit
{
  "token": "your-jwt-token"
}
🔐 Use the received JWT token in the Authorization header for protected endpoints:

sh
Copy
Edit
Authorization: Bearer your-jwt-token
🔹 3. Create a Todo
📍 Endpoint: POST /api/todo/add
📌 Headers:

sh
Copy
Edit
Authorization: Bearer your-jwt-token
📤 Request Body:
json
Copy
Edit
{
  "title": "Buy groceries",
  "description": "Milk, Bread, Eggs",
  "completed": false
}
📥 Response:
json
Copy
Edit
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Milk, Bread, Eggs",
  "completed": false,
  "createdAt": "2025-03-02T12:00:00Z"
}
🔹 4. Get All Todos
📍 Endpoint: GET /api/todo
📌 Headers:

sh
Copy
Edit
Authorization: Bearer your-jwt-token
📥 Response:
json
Copy
Edit
[
  {
    "id": 1,
    "title": "Buy groceries",
    "description": "Milk, Bread, Eggs",
    "completed": false
  },
  {
    "id": 2,
    "title": "Finish project",
    "description": "Complete the backend API",
    "completed": true
  }
]
🔹 5. Update a Todo
📍 Endpoint: PUT /api/todo/update/{id}
📌 Headers:

sh
Copy
Edit
Authorization: Bearer your-jwt-token
📤 Request Body:
json
Copy
Edit
{
  "title": "Buy groceries",
  "description": "Milk, Bread, Eggs, Butter",
  "completed": true
}
📥 Response:
json
Copy
Edit
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Milk, Bread, Eggs, Butter",
  "completed": true
}
🔹 6. Delete a Todo
📍 Endpoint: DELETE /api/todo/delete/{id}
📌 Headers:

sh
Copy
Edit
Authorization: Bearer your-jwt-token
📥 Response:
json
Copy
Edit
{
  "message": "Todo deleted successfully"
}
🧪 Testing the API
You can test the API using:

🟠 Postman
📟 cURL
📜 Swagger UI (if configured)
🤝 Contributing
Feel free to contribute by submitting issues or pull requests.

📜 License
This project is licensed under the MIT License.
