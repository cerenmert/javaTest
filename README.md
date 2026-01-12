# Java Test Project

This project contains a simple banking system implementation and various Java stream/collection examples. It is a Maven-based project using TestNG for testing.

## Project Structure

The project is organized into two main packages:

-   **`org.account`**: Contains the banking system logic.
    -   `Account`: Represents a bank account with properties like balance and debt.
    -   `AdvancedBankSystem`: Manages accounts and operations (add, delete, deposit, withdraw, loan).
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

-   **TestNG**: Used for unit testing the banking system.

## License

[MIT](https://choosealicense.com/licenses/mit/)
