# Student Management Web Application

A server-side Java web application where students can register, log in, update their profile and log out. The admin (user with id 1) can view and delete students.

## Tech Stack
Java, Servlets (Jakarta), JSP, JDBC, MySQL, Apache Tomcat 10.1, HTML

## Design
- **DAO pattern:** `Student` POJO, `StudentDAO` interface, `StudentDAOImpl` (JDBC CRUD) and a `ConnectionFactory` class
- **PreparedStatement** for every query to prevent SQL injection
- **HttpSession** for login state, `RequestDispatcher` for success and error messages
- Reusable `header.jsp` and `footer.jsp` through the JSP include directive

## Project Structure
```
src/main/java/com/dcl
  dto/Student.java            POJO
  dao/StudentDAO.java         DAO interface
  dao/StudentDAOImpl.java     JDBC implementation
  util/ConnectionFactory.java database connection
  servlet/                    Login, Register, Update, Delete, Logout
src/main/webapp               JSP pages (login, register, dashboard, updateAccount, viewStudents)
db/schema.sql                 database script
```

## Features
| Feature | Who |
|---|---|
| Register, login, logout | Student |
| Update own profile | Student |
| View all students | Admin |
| Delete a student | Admin |

## How to Run
1. Install MySQL, then run `db/schema.sql`.
2. In `ConnectionFactory.java`, set your MySQL username and password.
3. Import the project into Eclipse as a Dynamic Web Project and run it on Apache Tomcat 10.1.
4. Open `http://localhost:8080/StudentApp/` and register. The first user you register becomes the admin.

## Possible Improvements
- Hash passwords (for example BCrypt) instead of storing plain text
- Add input validation and a connection pool
- Move scriptlets to JSTL and a servlet-based controller
