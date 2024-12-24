# Internship Management Platform - Microservices Architecture

This platform is built using a microservices architecture to manage internship applications efficiently. It consists of several services working together, including IAM, Config Server, Discovery Server, Gateway, Stage, Mailing, and Gestion de Favoris. Each service has a specific role and communicates using REST APIs and OpenFeign.

---

## Services Overview

### 1. **IAM (Identity and Access Management)**
- **Purpose**: Manages user authentication and authorization using JWT tokens.
- **Features**:
  - User registration and login.
  - Token-based authentication.
  - Verifies if a user exists during interactions with other microservices.

### 2. **Config Server**
- **Purpose**: Centralized configuration management for all microservices.
- **Features**:
  - Stores configuration files for each service.
  - Simplifies updates and reduces redundancy.
- **Tech Stack**: Spring Cloud Config.

### 3. **Discovery Server (Eureka Server)**
- **Purpose**: Service discovery for all microservices.
- **Features**:
  - Ensures all services can register and discover each other dynamically.
  - Improves scalability and fault tolerance.

### 4. **Gateway**
- **Purpose**: Acts as a single entry point for all client requests.
- **Features**:
  - Routes requests to appropriate microservices.
  - Implements global security policies.
  - Handles API Gateway security and monitoring.

### 5. **Stage (Internship Service)**
- **Purpose**: Manages internship listings and details.
- **Features**:
  - Provides internship data via web scraping.
  - Ensures internships are valid and up-to-date.

### 6. **Mailing**
- **Purpose**: Sends emails for user interactions.
- **Features**:
  - Sends application emails when a user clicks "Apply" on the frontend.
  - Emails include the user's name and are sent to the company's email address.

### 7. **Gestion de Favoris (Favorites Management)**
- **Purpose**: Allows users to save their favorite internships.
- **Features**:
  - Checks with IAM to ensure the user exists.
  - Communicates with the Stage service to verify if the internship exists.
  - Stores and retrieves user-specific favorite internships.

---

## Architecture and Communication

- **Microservices Communication**:
  - All services communicate using REST APIs.
  - OpenFeign is used for inter-service communication.
- **Centralized Configuration**:
  - All configurations are managed by the Config Server.
- **Service Discovery**:
  - Eureka Server ensures dynamic service discovery and registration.

---

## Tech Stack
- **Backend**: Spring Boot, Spring Cloud (Config, Eureka, Gateway)
- **Security**: Spring Security, JWT
- **Communication**: REST APIs, OpenFeign
- **Database**: MySQL/MongoDB (as per service requirements)
- **Frontend**: Angular (for integration)
- **Mailing**: JavaMail API
- **Web Scraping**: JSoup

---

