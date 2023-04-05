# REST API for Insurace Management Platform .


This is a project for an Insurance Management Platform built with Spring Boot, designed to simplify the process of managing insurance policies, clients, and claims. 

Features
The platform allows users to manage insurance policies, clients, and claims easily and efficiently.
Users can create new policies, update existing ones, and view policy details.
Clients can be added to the platform, and policy details can be associated with clients.
Claims can be created, and their status can be updated as they are processed.
The platform provides a dashboard to help users keep track of their policies and claims.





# Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Swagger UI



# Services

- Claim Service
- Client Service
- Insurance Service



# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8088

    spring.datasource.url=jdbc:mysql://localhost:3306/imp;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```
https://localhost:8888/
```
```
http://localhost:8888/swagger-ui/index.html/
```

# ER Diagram
<img src="https://github.com/SanketPaharia/Insurance-Management-Platform/blob/master/ER%20diagram.png" >

# Controllers


<img src = "https://github.com/SanketPaharia/Insurance-Management-Platform/blob/master/InsurancepolicyController.png" >
<img src = "https://github.com/SanketPaharia/Insurance-Management-Platform/blob/master/ClaimClientController.png" >
<img src = "https://github.com/SanketPaharia/Insurance-Management-Platform/blob/master/Schemas.png" >

# Collaborator

- [Sanket Paharia](https://github.com/SanketPaharia)
