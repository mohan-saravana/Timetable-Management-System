# Timetable Management System

## Definition

The **Timetable Management System** is a Java-based console application developed to manage academic timetable records efficiently. It allows an administrator to securely log in and perform operations such as adding, viewing, updating, deleting, and searching timetable records.

The system uses **JDBC** for connecting the Java application with a **MySQL database** and follows a **Layered Architecture / DAO-Service pattern**.

---

## Project Synopsis

The Timetable Management System provides a simple and organized solution for maintaining academic timetable information. Instead of managing timetable records manually, administrators can use the application to store and manage timetable data in a MySQL database.

The system provides administrator authentication and a menu-driven interface for performing timetable management operations. The application is developed using **Java, JDBC, MySQL, and Maven**.

---

## Problem Statement

Managing academic timetables manually can be difficult, especially when there are many classes, subjects, teachers, rooms, and periods.

Traditional manual management may result in:

* Difficulty maintaining timetable records.
* Time-consuming updates.
* Difficulty searching for specific timetable information.
* Errors in maintaining records.
* Lack of centralized data storage.
* Difficulty managing timetable changes.

Therefore, the **Timetable Management System** is developed to provide a structured and efficient way to store, manage, update, delete, and search academic timetable records.

---

## Technologies Used

| Technology               | Purpose                                     |
| ------------------------ | ------------------------------------------- |
| **Java**                 | Application development                     |
| **JDBC**                 | Java-MySQL database connectivity            |
| **MySQL**                | Database and data storage                   |
| **Maven**                | Project and dependency management           |
| **Eclipse IDE**          | Development environment                     |
| **Layered Architecture** | Organizing application components           |
| **DAO-Service Pattern**  | Separating business and database operations |

The project presentation identifies Java, JDBC, MySQL, Maven, Eclipse, and the Layered Architecture/DAO-Service pattern as the technologies and structure used.

---

## Features of the Project

### 1. Admin Login

* Provides administrator authentication.
* Username and password are verified using the database.
* Invalid credentials display an error message.
* Successful authentication opens the Admin Menu.

### 2. Add Timetable

* Allows the administrator to add new timetable records.
* Stores timetable information in MySQL.

### 3. View Timetable

* Displays all available timetable records.

###  4. Update Timetable

* Allows existing timetable records to be modified using the record ID.

### 5. Delete Timetable

* Allows an existing timetable record to be removed after confirmation.

### 6. Search Timetable

* Allows timetable records to be searched based on the day.

These login, CRUD, and search functions are specified in the project presentation.

---

## Project Architecture

The project follows a **Layered Architecture** consisting of multiple layers.

```text
┌───────────────────────────────┐
│     Presentation / Main       │
│       User Interaction        │
└───────────────┬───────────────┘
                ↓
┌───────────────────────────────┐
│        Service Layer          │
│       Business Operations     │
└───────────────┬───────────────┘
                ↓
┌───────────────────────────────┐
│          DAO Layer            │
│      Database Operations      │
└───────────────┬───────────────┘
                ↓
┌───────────────────────────────┐
│         Utility Layer         │
│       DBConnection.java       │
└───────────────┬───────────────┘
                ↓
┌───────────────────────────────┐
│            MySQL              │
│       Persistent Storage      │
└───────────────────────────────┘
```

### Architecture Components

**Main / Presentation Layer**
Handles user interaction and the application menu.

**Service Layer**
Contains the business operations of the application.

**DAO Layer**
Handles database-related operations such as insert, select, update, and delete.

**Model Layer**
Contains application objects such as `User` and `Timetable`.

**Utility Layer**
Provides database connectivity through `DBConnection.java`.

**MySQL Database**
Stores user and timetable information permanently.

The architecture and its layers are described in the project presentation.

---

## Project Structure

```text
com.timetable
│
├── main
│   └── Main.java
│
├── model
│   ├── User.java
│   └── Timetable.java
│
├── dao
│   ├── UserDAO.java
│   └── TimetableDAO.java
│
├── daoimpl
│   └── JDBC Implementations
│
├── service
│   └── Service Interfaces
│
├── serviceimpl
│   └── Service Implementations
│
└── util
    └── DBConnection.java
```

This package structure follows the project presentation.

---

## Database

### Database Name

```text
timetable_db
```

### Users Table

```text
users
-----------------
id
username
password
```

### Timetable Table

```text
timetable
-----------------
id
class_id
day
period
subject_id
teacher_id
room_id
```

The project uses JDBC `PreparedStatement` for database operations.

---

##System Workflow

```text
Start
  ↓
Admin Login
  ↓
Validate Credentials
  ↓
Admin Menu
  ↓
┌────────┬────────┬────────┬────────┬────────┐
│  Add   │  View  │ Update │ Delete │ Search │
└────────┴────────┴────────┴────────┴────────┘
  ↓
MySQL Database
  ↓
Logout
  ↓
End
```

---

## Future Enhancements

The project can be enhanced in the future by adding:

* Graphical User Interface (GUI)
* Role-based access control
* Timetable conflict detection
* PDF timetable export
* Excel timetable export
* Automatic timetable generation

These enhancements are listed in the project presentation.

---

## Conclusion

The **Timetable Management System** provides an efficient approach to managing academic timetable records. It demonstrates the use of **Java, JDBC, MySQL, Maven, CRUD operations, administrator authentication, and layered architecture**.

The system reduces manual timetable maintenance and provides organized database storage. Its layered design also makes the application easier to maintain and extend with future features such as GUI support, conflict detection, timetable generation, and report export.

Overall, the project demonstrates how Java and MySQL can be combined to develop a structured and practical academic timetable management application.
