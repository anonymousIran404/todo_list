# Todo List API with Spring Boot 

A simple Java Spring Boot application to manage a Todo list.

---

##  Features

- REST ful API with full CRUD operations
- Integrated with MySQL using Spring Data JPA
- Swagger UI for easy API documentation
- Global exception handling

---

###  Technologies

- Java 17
- Spring Boot 3.2.4
- Spring Data JPA
- MySQL
- Springdoc OpenAPI 2.5.0

---

#### How to run :

Note: Please replace your_password_here in application.properties with 
      your own MySQL root password before running the projec
1. git clone https://github.com/gost-of-Warriors/todo-list.git

cd todo-list

2. CREATE DATABASE todo_app;

3. Run the Application
   Option 1: Using Maven:  ./mvnw spring-boot:run
    or for Windows : mvn spring-boot:run

   Option 2: Using IDE (like IntelliJ IDEA):
   Open the project and Run the TodoListApplication main class

4. Test the API
   Swagger UI: http://localhost:8080/swagger-ui.html
   OpenAPI Docs: http://localhost:8080/v3/api-docs

