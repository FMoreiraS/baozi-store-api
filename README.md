# Baozi Store API

## Overview

Baozi Store is a REST API for managing customers, products, and orders in a small bread shop, called Baozi Store.
It is built with Java and Spring Boot and persists data in MySQL.

## Tech stack

- Java 21
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- MySQL

## Prerequisites

Before running the project, install:

- Java 21
- MySQL

Create a MySQL user and set the following environment variables:

```bash
export USERNAME=your_mysql_username
export PASSWORD=your_mysql_password
```

On Windows PowerShell:

```powershell
$env:USERNAME="your_mysql_username"
$env:PASSWORD="your_mysql_password"
```

The application connects to `jdbc:mysql://localhost:3306/baozi_store` and automatically creates the
database if it does not exist.

## API endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| POST | `/customers` | Create a customer |
| POST | `/products` | Create a product |
| POST | `/orders` | Create an order |
| GET | `/customers` | Get all customers |
| GET | `/customers/{id}` | Get a customer by ID |
| GET | `/products` | Get all products |
| GET | `/products/{id}` | Get a product by ID |
| GET | `/orders` | Get all orders |
| GET | `/orders/{id}` | Get an order by ID |
| PUT | `/customers/{id}` | Update a customer |
| PUT | `/products/{id}` | Update a product |
| PUT | `/orders/{id}` | Update an order |
| DELETE | `/customers/{id}` | Delete a customer |
| DELETE | `/products/{id}` | Delete a product |
| DELETE | `/orders/{id}` | Delete an order |

## Running the application

Clone the repository and start the application:

```bash
git clone https://github.com/FMoreiraS/baozi-store-api.git
cd baozi-store-api
./gradlew bootRun
```

On Windows:

```powershell
git clone https://github.com/FMoreiraS/baozi-store-api.git
cd baozi-store-api
.\gradlew.bat bootRun
```

The API will be available at `http://localhost:8080`.

## Testing the API

Use an HTTP client such as Postman or Insomnia. Request templates are available in `src/main/resources/requestTemplates.http`.
