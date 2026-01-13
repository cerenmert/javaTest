# Java Test Project

This project contains a simple banking system implementation, product management implementation, student management implementation, and various Java stream/collection examples. 
It is a Maven-based project using TestNG for testing.

## Project Structure

The project is organized into the following main packages:

-   **`org.account`**: Contains the banking system logic.
    -   `Account`: Represents a bank account with properties like balance and debt.
    -   `AdvancedBankSystem`: Manages accounts and operations (add, delete, deposit, withdraw, loan).
-   **`org.product`**: Contains product management logic.
    -   `Product`: Simple POJO for products.
    -   `ProductDB`: Database simulation for products.
-   **`org.student`**: Contains student management logic.
    -   `Student`: Represents a student with ID, name, and grade.
    -   `StudentList`: Manages a collection of students with add/remove/fetch operations.
-   **`org.example`**: Contains various Java examples demonstrating:
    -   Stream API usage (grouping, filtering).
    -   List manipulation (concatenation, sorting).
    -   Map usage.
    -   Intersection of lists.

## Features

### Banking System
-   **Account Management**: Create and delete accounts.
-   **Transactions**: Deposit and withdraw funds.
-   **Loan System**: Take loans with interest and pay them back.

### Product Management
-   **Product Database**: Manage products and prices.
-   **Price Lookup**: Retrieve product prices efficiently.

### Student System
-   **Student List Management**: Add and remove students.
-   **Bulk Operations**: Add multiple students at once.
-   **Retrieval**: Fetch students by index or list all students.

### Java Examples
-   Finding the longest string in a list.
-   Grouping streams by length or other properties.
-   Sorting concatenated lists.
-   HashMap basic usage.

## Prerequisites

-   Java 15 or higher
-   Maven

## How to Run

### Run Tests
To execute the test suite (TestNG), run the following command:

```sh
mvn test
```

## Dependencies

-   **TestNG** 

## Latest Changes ( Student Management)

A new package `org.student` has been added:
-   **`Student`** and **`StudentList`**: Classes effectively manage student records.
-   **Tests**: `StudentTest` ensures functionality using **TestNG**.

## License

[MIT](https://choosealicense.com/licenses/mit/)
