# Bank Management System (CLI)

A menu-driven command line application built using **Core Java**, **MySQL**, and **JDBC**.  
This project demonstrates database-driven application development using JDBC with proper transaction handling.

---

## Features

- Create new bank account
- Secure login using Account Number and PIN
- Deposit money
- Withdraw money with balance validation
- Transfer money between accounts
- Balance enquiry
- View transaction history
- Menu-driven command line interface

---

## Technologies Used

- Java (Core Java, JDK 8+)
- MySQL
- JDBC (mysql-connector-j)
- Eclipse IDE

---

## Database Schema

### customers
- customer_id (Primary Key)
- name
- phone
- email
- pin

### accounts
- account_number (Primary Key)
- customer_id (Foreign Key)
- balance

### transactions
- txn_id (Primary Key)
- account_number
- txn_type
- amount
- txn_date

---

## How to Run the Project

1. Install Java (JDK 8 or above)
2. Install MySQL and start the MySQL server
3. Create the database and tables using the provided SQL script
4. Add `mysql-connector-j` JAR file to the project build path
5. Update MySQL username and password in `DBConnection.java`
6. Run `MainApp.java` as a Java Application in Eclipse

---

## Project Structure

BankManagementSystem/src
│
├── DBConnection.java
├── Customer.java
├── CustomerDAO.java
├── AccountDAO.java
├── TransactionDAO.java
└── MainApp.java


## How to Download and Run Locally

### Option 1: Download ZIP
1. Click **Code → Download ZIP**
2. Extract the ZIP file
3. Open Eclipse → File → Open Projects from File System
4. Select the extracted folder

### Option 2: Clone Using Git
```bash
git clone https://github.com/your-username/Bank-Management-System-Java-JDBC.git
