# Features of a relational database

## What is a Relational database

- Organizes data into tables (relations)
- Tables are linked by common fields (keys)
- Based on the relational model by E.F. Codd

## Anatomy of a Relational Database

- Tables (Entities)
- Records (Rows)
- Fields (Columns)
- Keys (Primary and Foreign)

## Key Characteristics of a Relational Database

- Data Consistency
- Data Integrity
- Data Security
- Efficiency and Speed

## SQL and Relational Databases

- SQL is used to manage relational databases
- Standard language for relational database management systems (RDBMS)

## Why use Relational Databases?

- Wide adoption and support
- Flexibility and scalability
- Strong consistency and ACID (Atomicity, Consistency, Isolation and Durability) compliance
- Rich ecosystem (tools, libraries, frameworks)

# Introduction to SQL

## What is SQL?

- Universal language for databases
- Allows for managing and manipulating relational databases

## Why SQL?

- Widely used in managing data
- Foundation for many advanceda database operations
- Vital for data analysis, database management, and data-driven decision making

# Types of SQL

## Categories of SQL

- Data Definition Language (DDL)
- Data Manipulation Language (DML)
- Data Control Language (DCL)
- Transaction Control Language (TCL)

## DDL

- CREATE: to create a new table or database
- ALTER: to modify an existing database object
- DROP: to delete an entire table or database

## DML

- SELECT: to select specific data from a database
- INSERT: to insert data into a table
- UPDATE: to update existing data within a table
- DELETE: to delete records from a database table

## DCL

- GRANT: to provide a privilege to the user
- REVOKE: to take back privileges from the user

## TCL

- COMMIT: to save the work done
- ROLLBACK: to undo the changes
- SAVEPOINT: to divide a transaction into smaller parts

## SQL in Action

```SQL
CREATE TABLE Employees (
  ID INT PRIMARY KEY,
  Name VARCHAR(50)
  Position VARCHAR(50),
  Department VARCHAR(50)
);

INSERT INTO Employees (ID, Name, Position, Department)
VALUES (1, 'John Doe', 'Software Engineer', 'Development');
```

# Setting MySQL up

```bash
  # creates and runs a MySQL container
  docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql

  # access to the container bash
  docker exect -it some-mysql bash

  # use MySQL CLI
  mysql -u root -p 
  # Then type your password
```

You can download some example databases from mysql website, https://dev.mysql.com/doc/index-other.html (Import the `.sql` files using the source command).

# SLQ 'Hello World'

```bash
mysql> select "Hello World!";
+--------------+
| Hello World! |
+--------------+
| Hello World! |
+--------------+
1 row in set (0.00 sec)
```

***SQL always returns tables!**

# SQL data types

- Several common data types
- Specific data types available may vary slightly
- Depends on the DBMS used

## Integer

- represents whole numbers withou decimal places
- can vay, such as INT, SMALLINT, or BIGINT

## DECIMAL/numeric

- decimal number with a specified precision and scale
- precision is the total number of digits
- scale is the number of decimal places

## Character strings

- CHAR: fixed-length character strings
- VARCHAR: variable-length character strings
- TEXT: large amounts of data

## Date and time

- DATA: a data without a time component
- TIME: a time without a date component
- TIMESTAP: both data and time
- DATETIME: both data and time

## Boolean (BOOL)

- a logical value: true or false

## Floating-point numbers

- for decimal numbers with floating-point precision
- FLOAT
- DOUBLE

## Binary data

- for binary or byte data
- BLOB (Binary Large Object)
- BINARY
- VARBINARY (for variable-length binary data)

## Others

- Enumerated types
- XML
- JSON
- UUID

# Data Definition Language

## What it is?

- Component of SQL
- Used for defining and managing database structures
- Contains commands like CREATE, ALTER, adn DROP

## The CREATE command

- used to create a new database ou tabble
- Basic syntax:
  ```sql
  CREATE DATABASE database_name;
  ```
  ```sql
  CREATE TABLE table_name (column1 datatype, column2 datatype, ...);
  ```

## Example of CREATE Command

```sql
CREATE DATABASE EmployeeDB;

CREATE TABLE Employees (
  ID INT PRIMARY KEY,
  Name VARCHAR(50)
  Position VARCHAR(50),
  Department VARCHAR(50)
);
```

## The ALTER Command
- Used to modify an existing database or table
  ```sql
  ALTER TABLE table_name ADD column_name datatype;
  ```
## Example of ALTER Command

```sql
ALTER TABLE Employees ADD Salary DECIMAL(8,2);
```

## The DROP Command

- Used to delete an entire database or table;
- Basic syntax:
  ```sql
  DROP DATABASE database_name;
  ```
  ```sql
  DROP TABLE table_name;
  ```

## Example of DROP Command

```sql
DROP DATABASE TestDB;

DROP TABLE TempEmployees;
```

# Table Creation Example

```bash
mysql> create database studentdb;
Query OK, 1 row affected (0.02 sec)

mysql> use studentdb;
Database changed

mysql> show tables;
Empty set (0.00 sec)

mysql> CREATE TABLE Students (
    ->   student_id INT AUTO_INCREMENT PRIMARY KEY,
    ->   name VARCHAR(100),
    ->   age INT,
    ->   gender ENUM('Male', 'Female', 'Other'),
    ->   contact_number VARCHAR(20),
    ->   enrollment_date DATE,
    ->   course_enrolled VARCHAR(100)
    -> );
Query OK, 0 rows affected (0.08 sec)

mysql> show tables;
+---------------------+
| Tables_in_studentdb |
+---------------------+
| Students            |
+---------------------+
1 row in set (0.00 sec)

mysql> desc Students;
+-----------------+-------------------------------+------+-----+---------+----------------+
| Field           | Type                          | Null | Key | Default | Extra          |
+-----------------+-------------------------------+------+-----+---------+----------------+
| student_id      | int                           | NO   | PRI | NULL    | auto_increment |
| name            | varchar(100)                  | YES  |     | NULL    |                |
| age             | int                           | YES  |     | NULL    |                |
| gender          | enum('Male','Female','Other') | YES  |     | NULL    |                |
| contact_number  | varchar(20)                   | YES  |     | NULL    |                |
| enrollment_date | date                          | YES  |     | NULL    |                |
| course_enrolled | varchar(100)                  | YES  |     | NULL    |                |
+-----------------+-------------------------------+------+-----+---------+----------------+
7 rows in set (0.01 sec)
```