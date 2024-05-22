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

### Example of CREATE Command

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
### Example of ALTER Command

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

### Example of DROP Command

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

# Data Manipulation Language

## What is it?

- Part of SQL
- Used for managin the data within tables
- Includes commands like SELECT, INSERT, UPDATE, and DELETE


## The SELECT command

- used to retrive data from a database
- Basic syntax:
  ```sql
    SELECT column_name FROM table_name WHERE condition;
  ```

### Example of SELECT command

```sql
  SELECT Name, Position
  FROM Employees
  WHERE Department = 'Development';
```

## The INSERT command

- used to insert new data into a table
- Basic syntax:
  ```sql
    INSERT INTO table_name (column1, column2, ...)
    VALUES (value1, value2, ...);
  ```

### Example of INSERT command

```sql
  INSERT INTO Employees (ID, Name, Position, Department)
  VALUES (1, 'John Doe', 'Software Engineer', 'Development');
```

## The UPDATE command

- used to modify existing data in a table
- Basic syntax:
  ```sql
    UPDATE table_name SET column1=value1, column2=value2, ...
    WHERE condition;
  ```

### Example of UPDATE command

```sql
  UPDATE Employees 
  SET Position = 'Senior Staff Poet'
  WHERE ID = 1;
```

## The DELETE command

- used to delete from a table
- Basic syntax:
  ```sql
    DELETE FROM table_name
    WHERE condition;
  ```

### Example of DELETE command

```sql
  DELETE FROM Employees
  WHERE ID = 1;
```

## DML hands on

```bash
mysql> INSERT INTO Students (name, age, gender, contact_number, enrollment_date, course_enrolled)
    -> VALUES ('Robert Frost', 20, 'Male', '1234567890', '2023-05-15', 'Computer Science');
Query OK, 1 row affected (0.01 sec)

mysql> SELECT * FROM Students;
+------------+--------------+------+--------+----------------+-----------------+------------------+
| student_id | name         | age  | gender | contact_number | enrollment_date | course_enrolled  |
+------------+--------------+------+--------+----------------+-----------------+------------------+
|          1 | Robert Frost |   20 | Male   | 1234567890     | 2023-05-15      | Computer Science |
+------------+--------------+------+--------+----------------+-----------------+------------------+
1 row in set (0.00 sec)

mysql> UPDATE Students SET contact_number = '9876543210' WHERE student_id = 1;
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

+------------+--------------+------+--------+----------------+-----------------+------------------+
| student_id | name         | age  | gender | contact_number | enrollment_date | course_enrolled  |
+------------+--------------+------+--------+----------------+-----------------+------------------+
|          1 | Robert Frost |   20 | Male   | 9876543210     | 2023-05-15      | Computer Science |
+------------+--------------+------+--------+----------------+-----------------+------------------+
1 row in set (0.00 sec)

mysql> DELETE FROM Students WHERE student_id = 1;
Query OK, 1 row affected (0.00 sec)

mysql> SELECT * FROM Students;
Empty set (0.00 sec)


mysql> use world;
Database changed

mysql> show tables;
+-----------------+
| Tables_in_world |
+-----------------+
| city            |
| country         |
| countrylanguage |
+-----------------+
3 rows in set (0.01 sec)

mysql> select * from city limit 10;
+----+----------------+-------------+---------------+------------+
| ID | Name           | CountryCode | District      | Population |
+----+----------------+-------------+---------------+------------+
|  1 | Kabul          | AFG         | Kabol         |    1780000 |
|  2 | Qandahar       | AFG         | Qandahar      |     237500 |
|  3 | Herat          | AFG         | Herat         |     186800 |
|  4 | Mazar-e-Sharif | AFG         | Balkh         |     127800 |
|  5 | Amsterdam      | NLD         | Noord-Holland |     731200 |
|  6 | Rotterdam      | NLD         | Zuid-Holland  |     593321 |
|  7 | Haag           | NLD         | Zuid-Holland  |     440900 |
|  8 | Utrecht        | NLD         | Utrecht       |     234323 |
|  9 | Eindhoven      | NLD         | Noord-Brabant |     201843 |
| 10 | Tilburg        | NLD         | Noord-Brabant |     193238 |
+----+----------------+-------------+---------------+------------+
10 rows in set (0.00 sec)

mysql> select Name, Code from country limit 10;
+----------------------+------+
| Name                 | Code |
+----------------------+------+
| Aruba                | ABW  |
| Afghanistan          | AFG  |
| Angola               | AGO  |
| Anguilla             | AIA  |
| Albania              | ALB  |
| Andorra              | AND  |
| Netherlands Antilles | ANT  |
| United Arab Emirates | ARE  |
| Argentina            | ARG  |
| Armenia              | ARM  |
+----------------------+------+
10 rows in set (0.00 sec)

mysql> select Name, Code from country WHERE Name = 'India';
+-------+------+
| Name  | Code |
+-------+------+
| India | IND  |
+-------+------+
1 row in set (0.01 sec)
```

# Understanding NULL in SQL

- NULL represents a missing/unknown value
- treated somewhat differently
- comparison operators don't work
- any arithmetic comparison with NULL results in NULL

## What NULL means?

- Value is undefined
- Value is unknown at the time
- Value is not applicable

## NULL properties

- Something can be NULL. But no equal to NULL
- Two NULLs are not equal

## How to check?
- IS NULL operator
- IS NOT NULL operator

### Example

```bash
mysql> INSERT INTO Students (name, age, gender, contact_number, enrollment_date, course_enrolled)
    -> VALUES ('Robert Frost', 20, 'Male', '1234567890', '2023-05-15', 'Computer Science');

mysql> INSERT INTO Students (name, age, gender, contact_number, enrollment_date, course_enrolled)
    -> VALUES ('Maya Angelou', 22, 'Female', NULL, '2023-06-01', 'Poetry');

mysql> select * from Students;
+------------+--------------+------+--------+----------------+-----------------+------------------+
| student_id | name         | age  | gender | contact_number | enrollment_date | course_enrolled  |
+------------+--------------+------+--------+----------------+-----------------+------------------+
|          2 | Robert Frost |   20 | Male   | 1234567890     | 2023-05-15      | Computer Science |
|          3 | Maya Angelou |   22 | Female | NULL           | 2023-06-01      | Poetry           |
+------------+--------------+------+--------+----------------+-----------------+------------------+
2 rows in set (0.00 sec)

mysql> select * from Students where contact_number = NULL;
Empty set (0.00 sec)

mysql> select * from Students where contact_number IS NULL;
+------------+--------------+------+--------+----------------+-----------------+-----------------+
| student_id | name         | age  | gender | contact_number | enrollment_date | course_enrolled |
+------------+--------------+------+--------+----------------+-----------------+-----------------+
|          3 | Maya Angelou |   22 | Female | NULL           | 2023-06-01      | Poetry          |
+------------+--------------+------+--------+----------------+-----------------+-----------------+
1 row in set (0.00 sec)

mysql> select * from Students where contact_number IS NOT NULL;
+------------+--------------+------+--------+----------------+-----------------+------------------+
| student_id | name         | age  | gender | contact_number | enrollment_date | course_enrolled  |
+------------+--------------+------+--------+----------------+-----------------+------------------+
|          2 | Robert Frost |   20 | Male   | 1234567890     | 2023-05-15      | Computer Science |
+------------+--------------+------+--------+----------------+-----------------+------------------+
1 row in set (0.00 sec)
```

# Query clauses

## SELECT
- specify the columns or expressions to retrive from the table
- determines which data elments are in the query result

## FROM
- specify table(s) to retrive data from
- identifies the source of the data for the query

## WHERE
- filter the rows in the table based on specified conditions
- criteria must be met for a row to be included in the query result

## GROUP BY 
- group rows together based on one or more columns
- typically used with aggregate functions like COUNT, SUM, AVG, etc

## HAVING
- filter the groups created by the GROUP BY clause
- conditions must be met by the groups themselves
- similar to the WHERE clause which operates on individual rows

## ORDER BY
- sort the result set based on column(s)
- control the sequence of rows in the query result

## LIMIT/OFFSET
- often used together for pagination
- LIMIT restricts the number of rows
- OFFSET specifies the starting point

# Order of evaluation of a SELECT query

1. FROM: identifies the table(s)
2. WHERE: filters the rows
3. GROUP BY: result set is grouped
4. HAVING: filters the grouped data
5. SELECT: selects the columns or expressions to be included
6. ORDER BY: result set is sorted based on specified column(s)
7. LIMIT/OFFSET: result is limited and offset if applicable

# SQL table types

- Permanent tables (normal tables)
- Derived tables (results of a query, a subselect for example)
- Temporary tables (`CREATE TEMPORARY TABLE`, so it exists during a session)
- Virtual tables (Views - queries 'pretending' to be a table, `CREATE VIEW view_name AS your_query`)

## Views
- No actual table exists
- Just remembers the query
- When you use the view, it auto-wraps the query
- Performance implications
- Used to simplify queries by extracting complexity
- Used to hide columns from people

# Group by and Order by

Example:
```sql
  SELECT CountryCode, sum(Population) 
  FROM city 
  GROUP BY CountryCode 
  HAVING sum(Population) > 1700000 
  ORDER BY sum(Population) DESC; -- you could use '2' (index) instead of 'sum(Population)' or even a alias
```

# Data Control Language (DCL)

- Subset of SQL
- Used for controlling access to data in a database
- Includes commands like GRANT and REVOKE:
    - used for security
    - determine user roles and necessary privileges
    - grant only the necessary privileges
    - regulary review and revoke unnecessary privileges

## The GRANT Command
- Used to give users permissions
- Basic syntax:
```sql
 GRANT privilege_name ON object_name TO {user_name|PUBLIC|role_name}
```
### Example of GRANT Command

```sql
 GRANT SELECT, INSERT ON Employees TO John;
```

## The REVOKE Command
- Used to take back permissions from users
- Basic syntax:
```sql
 REVOKE privilege_name ON object_name FROM {user_name|PUBLIC|role_name}
```
### Example of REVOKE Command

```sql
 REVOKE INSERT ON Employees FROM John;
```

# Foreign key

- one or more columns in a table
- provides a link to data in other tables
- used to cross-reference tables
- help maintain data integrity
- must match the primary key column of another table
- or be NULL

## Example

```sql
  CREATE TABLE Customers (
    CustumerID INT PRIMARY KEY,
    FirstName VARCHAR(100),
    LastName VARCHAR(100)
  );

  CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    CustomerID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
  );
```

# Joins

- let us _join_ tables
- let us specify _how_ they are joined

## Default JOIN (INNER JOIN)

- All possible combinations (Cartesian product)

## The ON clause

- filtering happens when retriving and joining the tables
- only relevant rows that satisfy the ON condition are combined
- more efficient to put that condition in the ON clause rather than the WHERE
- database's query optmizer might do that anyway, but use ON for join as best practice

### Example

Getting all orders with their corresponding customer and filtering the customers
that have informed their email.

```sql
  SELECT o.OrderID, c.CustomerName, c.CustomerEmail
  FROM Orders o
  JOIN Customers c
  ON o.CustomerID = c.CustomerID
  WHERE c.CustomerEmail IS NOT NULL;
```


## OUTER JOIN
- returns records even if there is no match in the other table
- types: LEFT JOIN, RIGHT JOIN, FULL JOIN

## LEFT OUTER JOIN (LEFT JOIN)

- all the rows from the left table and the matched rows from the right table
- if there is no match, the result is NULL on the right side

### Example

Getting all customers with their orders, even if they dont have orders (in that
case the order will be NULL)

```sql
  SELECT c.CustomerName, o.OrderID
  FROM Customers c
  LEFT JOIN Orders o
  ON c.CustomerID = o.CustomerID;
```

## RIGHT OUTER JOIN

- all the rows from the right table and the matched rows from the left table
- if there is no match, the result is NULL on the left side

### Example

Getting all orders with its customer, but for orders that dont have a customer
the customer will be NULL, or will not show up in the result

```sql
  SELECT c.CustomerName, o.OrderID
  FROM Customers c
  RIGHT JOIN Orders o
  ON c.CustomerID = o.CustomerID;
```

## FULL OUTER JOIN
- all rows when there is a match in either the left table or the right table
- if there is no match, the result is NULL on either side

### Example

Getting all customers and all orders, with null in the place of the customer/order if it is missing

```sql
  SELECT c.CustomerName, o.OrderID
  FROM Customers c
  FULL JOIN Orders o
  ON c.CustomerID = o.CustomerID;
```

## Remember

- not all databases support all types of joins
- example: `FULL JOIN` not supported by MySQL
- most result can be achived by a combination of joins

## Joins on derived queries

Number of orders for customer ids
```sql
  SELECT CustomerID, COUNT(*) as NumberOfOrders
  FROM Orders
  GROUP BY CustomerID
  HAVING COUNT(*) > 1
```

Now JOIN to get names and order counts!

```sql
 SELECT c.CustomerName, co.NumberOfOrders
 FROM Customers c
 JOIN (
  SELECT CustomerID, COUNT(*) as NumberOfOrders
  FROM Orders
  GROUP BY CustomerID
  HAVING COUNT(*) > 1
 ) co ON c.CustomerID = co.CustomerID;
```

# Subqueries and nested queries

## What are Subqueries?

- queries embedded within other queries
- can return data used in the outer query
- can be used in SELECT, INSERT, UPDATE, DELETE, WHERE, and FROM clauses

## Types of Subqueries

### Scalar subquery

- returns a single value
- used where a single value is expected
- in a SELECT, WHERE, or in a expression
- Example:
  ```sql
    SELECT name, age
    FROM students
    WHERE age > (SELECT AVG(age) FROM students);
  ```

### Row subquery

- returns a single row of data
- used where a single row is expected
- in a FROM clause or as part of a comparison
- Example:
  ```sql
    SELECT *
    FROM students
    WHERE (name, age) = (SELECT name, age FROM other_table WHERE condition);
  ```

### Column subquery

- returns a single column of data
- used where a single column is expected
- in the SELECT clause or an IN or EXISTS condition
- Example:
  ```sql
    SELECT name
    FROM students
    WHERE age IN (SELECT age FROM other_table WHERE condition);
  ```

### Table subquery

- also known as derived table
- used as virtual table in the FROM clause
- treat the result of the subquery as a temporary table
- Example:
  ```sql
    SELECT *
    FROM (SELECT name, age FROM other_table WHERE condition) AS subquery_table
    WHERE subquery_table.age > 20;
  ```

## Nested Queries

- Subqueries nested inside another subquery
- Can be multiple levels deep
- Require careful construction and testing

### When to use?

- Breaking down complex problems
- When operations need to be performed in a specific order
- Querying data from multiple tables that dont have a direct link

### Pontential Drawbacks

- Can be difficult to read and debug
- Can lead to performance issues if not optimized correctly
- Deeply nested queries can become overly complex

# Understanting SQL indexes

## What is it?

- Database structure to improve the speed of data retrieval
- Acts like a lookup table
- Typically used on columns used in WHERE clause, JOIN operations

## Example

- `Users` table
- fields `UserID`, `UserName`, and `Email`

```sql
  SELECT * FROM Users
  WHERE UserID = 10;
```

This query should have the time complexity of O(N), like it was doing a full
table scan, but no! The timecomplexity is actually sublinear, due to database
optimization, they actually create an index, but just for primary keys!

If you want to optimize the search using another column you can create a index:
```sql
  CREATE INDEX idx_users_email
  ON Users (Email);
```

## Composite index

- what we saw was single column index
- can create compisite index with multiple columns
- speed up queries that specify both or the first

## Benefits of Indexes

- Improve query performance
- Avoids full table scan
- Sub-lenar performance
- Allow quicker sorting and grouping of data

## Drawbacks of Indexes

- they slow down write operations such as `INSERT`, `UPDATE`, and `DELETE`
- with every write, any indexes should be updated
- require storage space

# Using SQL Triggers

## What is it?

- Special procedures that are automatically executed in response to certain events
- Used to enforce business rules or data integrity
- Can respond to INSERT, UPDATE, and DELETE events

## Benefits

- Can automatically enforce business rules or data integrity
- Make your database more robust and self-sufficient
- Reduce the amount of application code needed

## Example

Given those two tables:

```sql
  CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50)
    department VARCHAR(50),
    salary DECIMAL(10, 2)
  );

  CREATE TABLE salary_history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    old_salary DECIMAL(10, 2),
    new_salary DECIMAL(10, 2),
    change_date DATE,
    FOREIGN KEY (employee_id) REFERENCES employees(id)
  );
```

We want add a record to the salary history when an employee's salary is updated, and
we can do that with a trigger:

```sql
  CREATE TRIGGER salary_update_trigger
  AFTER UPDATE ON employees
  FOR EACH ROW
  BEGIN
    IF NEW.salary != OLD.salary THEN
      INSERT INTO salary_history (employee_id, old_salary, new_salary, change_date)
      VALUES (OLD.id, OLD.salary, NEW.salary, CURDATE());
    END IF;
  END;
```

## Disadvantages
- non-relational interdependies
- can cause performance slowdowns
- "magic" is hard to debug