# Cofradía Management REST API 🕯️

**Author:** Daniel Fernández Roldán  
**Status:** Version 1.0 (Completed)

## 📌 Project Overview
This project is a robust, scalable RESTful API built with **Spring Boot** and **Java**. It is designed to manage the internal operations of a traditional Brotherhood (*Cofradía*), specifically handling the registry of members (*hermanos*) and the inventory/loan system of brotherhood assets (*enseres*). 

As a senior Computer Engineering student project, the architecture was meticulously designed prioritizing decoupling, data security, and scalability for future frontend integrations (React/Angular).

## 🛠️ Tech Stack
*   **Core:** Java 21, Spring Boot 3.x
*   **Database:** MySQL, Spring Data JPA, Hibernate
*   **API Documentation:** Swagger / OpenAPI 3.0
*   **Build Tool:** Maven

## 🚀 Architectural Challenges & Milestones

The development of this backend was structured around 10 core engineering challenges, ensuring enterprise-level standards at every layer:

*   **1 & 2. Environment Setup & DB Integration:** Configured the Spring Boot application and established a secure connection to a relational MySQL database using `application.properties` and HikariCP.
*   **3 & 4. Entity Mapping & Relational Logic:** Designed the database schema using JPA annotations. Implemented a robust relationship between `Member` and `Asset` entities, allowing for accurate tracking of loaned inventory.
*   **5. Controller Layer & CRUD Operations:** Developed standard RESTful endpoints (`GET`, `POST`, `PUT`, `DELETE`) adhering to proper HTTP status codes and REST naming conventions.
*   **6. Data Transfer Object (DTO) Pattern:** Decoupled the database layer from the API exposure layer. Implemented `AssetDTO` to prevent the leakage of sensitive member data (e.g., National ID) when querying inventory status, returning only flattened, necessary information.
*   **7. Data Validation:** Hardened the API against corrupt or malicious data using `jakarta.validation`. Implemented strict entity constraints (e.g., `@NotBlank`, `@Size` for National IDs) at the controller level using the `@Valid` annotation.
*   **8. Global Exception Handling:** Engineered a `@RestControllerAdvice` interceptor to catch internal server errors and validation failures. This transforms standard Java stack traces into clean, readable JSON responses, greatly improving the developer experience for frontend consumers.
*   **9. Scalability via Pagination:** Prevented potential memory bottlenecks when handling thousands of database records by implementing Spring Data's `Pageable` interface on `Member` retrieval endpoints.
*   **10. CORS Configuration:** Secured and prepared the API for cross-origin requests, explicitly enabling communication with isolated frontend environments (like Vite/React on port 5173 or Angular on port 4200).

## ⚙️ How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone <your-repository-url>

2. **Configure the Database:**
   Ensure you have a local instance of MySQL running. Update the `src/main/resources/application.properties` with your local database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/cofradia_db?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```
3. **Run the Application:**
   Open the project in your IDE (IntelliJ IDEA recommended) and run the main application class, or use Maven:
   ```bash
   mvn spring-boot:run
   ```
4. **Access the API Documentation:**
   Once the server is running on port `8080`, navigate to Swagger UI to explore and test all endpoints interactively:
   `http://localhost:8080/swagger-ui/index.html`

## 🔮 Future Roadmap
While this backend MVP is fully operational, future iterations could include:
*   Implementation of Spring Security and JWT for role-based endpoint authorization.
*   Unit and Integration testing using JUnit 5 and Mockito.
*   Containerization using Docker for seamless deployment.
