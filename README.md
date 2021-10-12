# FastBuy


# Project Description

This Online Shopping is a console-based menu driven application that simulates online shopping experience. An employee can add Products. A Customer can place order on the products. The employee delivers the Product to the Customer and keeps updating the tracker to track the orders placed. Employee maintains products in the system. Customer has a order history and can also view products from categories and can add it to cart for checkout.



# Technologies Used

Java

MySQL Database

Maven

JDBC

JUnit

Log4j




# Features

As an user, I can login.
As a employee, I can add a new product.
As a customer, I can signup using my email, first name, last name and password.
As a customer, I can view the list of products with price.
As a customer, I can add a product to cart.
As a customer, I can view the cart with product list and total.
As a customer, I can place orders on the items in cart. Each product in the cart becomes an individual order.
As a employee, I can mark the status of an order as shipped.
As a customer, I can mark the order as received.
As a customer, I can view all my orders and it's status.
As a user, I can logout of my session.
As a employee, he can search customer by various filters like email, id, name, orderid etc.



# To-do list

Data is stored in a database.
Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects.
Service Layer need to be implemented which depends on Data Access layer for getting data from database.
Presentation Layer (console) should depend on Service Layer to implement each feature.
All input is received using the java.util.Scanner class.
Log4j is implemented to log events to a file.
A minimum of 5 JUnit test is written to test some functionality.



# Usage

Users must register for the Shopping App Application on the registration page(Implemented using Scanner class). Then, they must login on the home page (login page). All of the application's functionality will then be open after logging in..
