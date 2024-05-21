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

## SLQ 'Hello World'

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

