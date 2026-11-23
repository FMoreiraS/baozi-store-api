# Baozi Store

## Case study

A small bread shop called Baozi Store sells the Chinese "baozi", a stuffed bun. To enhance the management of
customers, products, and orders, it was suggested to create a simple system. It must allow the users to save,
read, update and delete each of those entities, and data must be persisted in a relational database.

## Technologies

- Java 17
- MySQL
- Spring (Web and Data JPA)

## What the app does

Once working, the API offers endpoints to allow performing CRUD operations with any entity:
- `POST`
  - `/customers`
  - `/products`
  - `/orders`
- `GET`
  - `/customers`
  - `/customers/{id}`
  - `/products`
  - `/products{id}`
  - `/orders`
  - `/orders/{id}`
- `PUT` or `DELETE`
  - `/customers/{id}`
  - `/products{id}`
  - `/orders/{id}`

## How to run

In your command line, run these commands:
`git clone https://github.com/FMoreiraS/baozi-store-api`  
`gradle bootRun src/main/java/com/fmoreiras/baozistore/BaoziStoreApplication`  

Since the Spring application is running, you can test the endpoints using a dedicated tool, such as Postman.
Alternatively, you can open a browser, search for `localhost:8080` and use the dev tools (`Ctrl + Shift + I`
in Firefox). There you can make HTTP requests. To help with this, I wrote a file with templates for all the
available requests, take a look at `src/main/resources`.
