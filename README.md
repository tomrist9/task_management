## 📝 Task Management System

Task Management System is a Spring Boot–based backend application that provides user management, authentication, and task-related operations.  
The project is designed using clean architecture principles and a layered structure.

---

##  Features

###  User Management
- User registration and account verification
- Secure login and authentication
- Account recovery (password reset)
- Role-based access control

###  Security
- Spring Security integration
- Authentication & authorization handling
- Custom authentication exceptions
- Secured REST endpoints

###  Architecture & Design
- Layered architecture (Controller, Service, Repository)
- DTO ↔ Entity mapping
- Custom exception handling
- Separation of concerns

---

##  Tech Stack

- Java
- Spring Boot
- Spring Security
- Gradle
- REST API
- Hibernate / JPA
- PostgreSQL / H2 (configurable)

---

## 📁 Project Structure

```text
src/main/java/com/example/user_management
│
├── config            # Application & security configurations
├── constant          # Constants & enums
├── controller        # REST controllers
├── dao               # Data access layer
├── exceptions        # Custom exception handling
├── mapper            # DTO ↔ Entity mappers
├── model             # Domain models / entities
├── notification      # Notification-related logic
├── registration      # User registration & verification
├── repository        # JPA repositories
├── security          # Security configurations
├── service           # Business logic
├── signin            # Authentication logic
├── task_management   # Task-related logic
│
└── UserManagementApplication.java
```



---

##  API Overview

- `POST /auth/login` – User login
- `POST /auth/register` – User registration
- `POST /auth/verify` – Account verification
- `POST /auth/recover` – Account recovery
- `GET /tasks` – Fetch tasks (secured)
- `POST /tasks` – Create task (secured)

> Secured endpoints require authentication.

---

##  How to Run the Project

### Clone the repository
```bash
git clone https://github.com/tomrist9/task_management.git
cd task_management
