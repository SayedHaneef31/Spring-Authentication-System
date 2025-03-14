
# Spring Security with JWT Authentication
This project is a Spring Boot application that implements JWT-based authentication and authorization using Spring Security. It provides secure access to protected resources, allowing users to register, log in, and access endpoints with a valid JWT token.


## Features

✅ User Authentication (Login & Registration)

✅ JWT-based Authorization

✅ Secure API Endpoints

✅ Role-Based Access Control

✅ PostgreSQL Database Integration
## Tech Stack

**Backend:** Spring Boot, Spring Security, JWT

**Database:** PostgreSQL

**Tools:** Postman (API Testing), pgAdmin 4

## Run Locally

Clone the project

```bash
  git clone https://github.com/SayedHaneef31/Spring-Authentication-System.git
  cd your-repo
```

Configure the PostgreSQL database in application.properties



Run the application using
```bash
  mvn spring-boot:run
```

Test authentication via Postman.



# *Project Roadmap*

### **Project Initialization**

#### 1. Initialize the Project  
- Set up your project structure.  
- Configure your database.  
- Create necessary packages for **Entity**, **Service**, and **Repository**.  

#### 2. Import Dependencies  
- Import the Spring Security dependency into your project.  

---

### **Security Configuration**  

#### 3. Implement CSRF Token  
- Set up CSRF token generation and retrieval to secure your endpoints.  

#### 4. Implement Custom Username and Password  
- Configure how the application will handle username and password.  

#### 5. Add a Custom Security Configuration  
- Define your security rules, permitted endpoints, and add your filters.  

---

### **API Development**  

#### 6. Add User and Product Endpoints  
- Create the **Entity**, **Service**, and **Repository** layers for User and Product.  
- Implement **GET** and **POST** endpoints.  

#### 7. Implement a Login API to Validate Credentials (Locally)  
- Set up a basic login API to test credential validation.  

#### 8. Implement CustomUserDetailsService  
- Fetch user details from your database by implementing a custom `UserDetailsService`.  

#### 9. Configure Authentication Provider  
- Use `DaoAuthenticationProvider` for authentication.  

#### 10. Encode Passwords Before Saving to the Database  
- Use `BCryptPasswordEncoder` to securely hash passwords before persisting.  

#### 11. Authentication is Complete!  
- At this point, your basic authentication system should be functional.  

---

### **JWT Implementation**  

#### 12. Retrieve JWT Token After Successful Login  
- On successful authentication, generate and return a JWT token.  

#### 13. Implement the Authentication Manager Method  
- Integrate and configure the `AuthenticationManager`.  

#### 14. Add JJWT Dependencies  
- Load the following JJWT dependencies:  
  - **JJWT-API**  
  - **JJWT-IMPL**  
  - **JJWT-Jackson**  

#### 15. Configure JWT Secret  
- Import a Base64 encoded JWT secret key in your `application.properties`.  

#### 16. Create `JwtService` and Method to Retrieve JWT Token  
- Develop a service method that builds the JWT using user details.  

#### 17. Integrate JWT into the Filter Chain  
- With the generated JWT token, bypass the `UsernamePasswordAuthentication` in the filter chain.  

#### 18. Implement `JwtAuthenticationFilter`  
- Create a filter by extending `OncePerRequestFilter`.  
- Override the `doFilterInternal(request, response, filterChain)` method to handle JWT validation.  
