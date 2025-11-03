# JDBC CRUD Project 🚀

This project demonstrates how to perform **CRUD (Create, Read, Update, Delete)** operations using **JDBC (Java Database Connectivity)** with **PostgreSQL**.  
It also includes **Batch Processing** and **Transaction Management** examples — making it a complete JDBC learning project.

---

## 🧠 Concepts Covered

- ✅ Connecting Java with PostgreSQL using JDBC
- ✅ Using `Statement` and `PreparedStatement`
- ✅ Performing CRUD operations
- ✅ Executing batch SQL operations
- ✅ Managing transactions (commit & rollback)
- ✅ Handling exceptions and resources with try-with-resources
- ✅ Maven integration (no manual JAR setup)

---

## 🏗️ Project Structure

jdbc_crud_project/
├── src/
│ └── main/
│ └── java/
│ └── com/
│ └── dhairya/
│ ├── Main.java # Test DB connection
│ ├── InsertExample.java # INSERT operation
│ ├── SelectExample.java # SELECT operation
│ ├── UpdateExample.java # UPDATE operation
│ ├── DeleteExample.java # DELETE operation
│ ├── BatchExample.java # Batch processing
│ └── TransactionExample.java# Transaction demo
├── pom.xml
└── README.md

## ⚙️ Prerequisites

Before running the project, make sure you have:

- **Java 17+**
- **Maven 3.9+**
- **PostgreSQL 15+**
- A database named `dhairyadb`
- A table named `students`

You can create the table with:
```sql
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    course VARCHAR(100),
    email VARCHAR(100)
);

🚀 How to Run
1️⃣ Compile the project
mvn compile

2️⃣ Run any example (replace Main with class name)
mvn exec:java -Dexec.mainClass="com.dhairya.Main"
or
mvn exec:java -Dexec.mainClass="com.dhairya.InsertExample"

🧩 Dependencies

Managed through Maven in pom.xml:
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
</dependency>

🧑‍💻 Author

Dhairya Bhadani
Passionate about Java backend development, exploring frameworks like Spring Boot, Hibernate, and JPA.
Let’s connect and build great things!

🌟 Future Plans
Integrate with Hibernate / JPA
Add Spring Boot version of the same project
Create REST APIs for student management
