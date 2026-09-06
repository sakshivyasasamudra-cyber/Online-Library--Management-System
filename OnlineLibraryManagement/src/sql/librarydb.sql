CREATE DATABASE librarydb;

USE librarydb;
DESCRIBE issued_books;

CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(50),
    author VARCHAR(50),
    available BOOLEAN
);

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(50),
    student_usn VARCHAR(30),
    student_SEM INT
);
CREATE TABLE issued_books (
    issue_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    book_id INT,
    issue_date DATE,
    return_date DATE NULL ,
    fine DOUBLE
);