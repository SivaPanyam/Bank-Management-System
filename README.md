# Bank Management System

The **Bank Management System** is a Java-based application developed using Eclipse.  
It follows a **Five-Layer Architecture** to ensure clean separation of concerns, better maintainability, and scalability.

---

## Project Objective

The goal of this project is to simulate basic banking operations such as:
- Account creation
- Deposits and withdrawals
- Balance inquiry
- Customer and transaction management

The system is designed using layered architecture to keep the code modular and easy to extend.

---

## Five-Layer Architecture Overview

This project follows a **five-layer (n-tier) architecture**:

Presentation Layer
↓
Controller Layer
↓
Service Layer
↓
DAO (Data Access) Layer
↓
Database Layer


Each layer has a specific responsibility and communicates only with adjacent layers.

---

## 1. Presentation Layer

**Purpose:**  
Handles user interaction and input/output.

**Responsibilities:**
- Displays menus and messages
- Takes user input from console or UI
- Sends requests to the Controller layer

**Examples:**
- `Main.java`
- Menu or UI classes

---

## 2. Controller Layer

**Purpose:**  
Acts as a bridge between the Presentation and Service layers.

**Responsibilities:**
- Receives user requests
- Validates basic input
- Calls appropriate service methods
- Returns responses back to the Presentation layer

**Examples:**
- `AccountController.java`
- `TransactionController.java`

---

## 3. Service Layer

**Purpose:**  
Contains the core business logic of the application.

**Responsibilities:**
- Implements banking rules and validations
- Processes transactions
- Coordinates multiple DAO calls
- Ensures consistency and integrity

**Examples:**
- `AccountService.java`
- `TransactionService.java`

---

## 4. DAO (Data Access Object) Layer

**Purpose:**  
Handles all data-related operations.

**Responsibilities:**
- Performs CRUD operations
- Communicates with the database or data source
- Isolates database logic from business logic

**Examples:**
- `AccountDAO.java`
- `TransactionDAO.java`

---

## 5. Database Layer

**Purpose:**  
Stores application data persistently.

**Responsibilities:**
- Maintains tables/records
- Stores account, customer, and transaction data

**Implementation:**
- Can be implemented using:
  - MySQL / PostgreSQL (JDBC)
  - File-based storage (for learning projects)

---



## Why Five-Layer Architecture?

- Clear separation of concerns
- Easier debugging and testing
- Better scalability
- Industry-standard design
- Easy to explain in interviews

---

## Technologies Used

- Java
- Eclipse IDE
- JDBC (optional, if database is used)
- Git & GitHub

---

## How to Run the Project

1. Clone the repository
2. Open Eclipse → Import → Existing Java Project
3. Select the project folder
4. Run `Main.java`

---

## Author

**Siva Panyam**  
Computer Science & Engineering  
Academic Project

---

## Status

✔ Five-layer architecture implemented  
✔ Clean project structure  
✔ Ready for academic and portfolio use  
