<<<<<<< HEAD
# Movie-Database-Management-System
This project is purly based on CRUD operation using java and mysql database. Where we perform various operation related movie.
=======
## Getting Started

Welcome to the VS Code Java world. Her# 🎬 Movie Watch List Management System  
### (Module 4 - JDBC Project)

This is a Java-based console application developed using JDBC and MySQL.  
It allows users to manage a movie watch list by performing CRUD operations.

This project is created as part of Module 4 (M4) in Advance Java.

---

## 📌 Project Objective

The main objective of this project is:

- To understand JDBC connectivity
- To perform database operations using Java
- To learn CRUD functionality
- To store and manage movie data efficiently

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- JDBC
- MySQL Database
- VS Code / Eclipse
- Windows OS

---

## ✨ Features

✔ Insert new movie records  
![Insert Data](screenshots/insert.png)

✔ Display all movies  
![Program Output](screenshots/view table.png)

✔ Update movie details  
![Upddate row](screenshots/update.png)

✔ Delete movies  
![Delete row](screenshots/delete&view.png)

✔ Menu-driven interface
![Program Output](screenshots/menu.png)

✔Particular Movie Details
![View a particular movie](screenshots/partuculardetails.png)
 
✔ MySQL database storage  
![Program Output](screenshots/mysql.png)

---

## 📂 Database Details

### Database Name: `project`

### Table Name: `watch_list`

| Column | Type         | Description          |
|--------|--------------|----------------------|
| sl     | INT (PK)     | Serial Number        |
| name   | VARCHAR(100) | Movie Name           |
| genre  | VARCHAR(100) | Movie Genre          |
| rating | DOUBLE       | Movie Rating         |
| status | VARCHAR(50)  | Watched / Not Watched|

---

## ⚙️ Database Creation

Run the following SQL commands:

```sql
CREATE DATABASE project;

USE project;

CREATE TABLE watch_list (
    sl INT PRIMARY KEY,
    name VARCHAR(100),
    genre VARCHAR(100),
    rating DOUBLE,
    status VARCHAR(50)
);
e is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
>>>>>>> 797f15d (This is the mini project of advance java.)
