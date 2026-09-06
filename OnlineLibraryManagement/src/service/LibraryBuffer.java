package service;

import database.DBConnection;
import model.Book;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LibraryBuffer {

    int MAX_LIMIT = 3;

    public synchronized void issueBook(
            Student student,
            Book book
    ) throws Exception {

        System.out.println(
                "issueBook method called"
        );

        if (student
                .getIssuedBooks()
                .size() >= MAX_LIMIT) {

            throw new Exception(
                    "Cannot issue more than 3 books"
            );
        }

        if (book.isAvailable()) {

            student
                    .getIssuedBooks()
                    .add(book);

            book.setAvailable(false);

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO issued_books(student_id, book_id, issue_date, return_date, fine) VALUES(?,?,?,?,?)"
                    );

            ps.setInt(
                    1,
                    student.getStudentId()
            );

            ps.setInt(
                    2,
                    book.getBookId()
            );

            ps.setDate(
                    3,
                    new java.sql.Date(
                            System.currentTimeMillis()
                    )
            );

            ps.setNull(
                    4,
                    java.sql.Types.DATE
            );

            ps.setDouble(5, 0);

            ps.executeUpdate();

            PreparedStatement ps2 =
                    con.prepareStatement(
                            "UPDATE books SET available = 0 WHERE book_id = ?"
                    );

            ps2.setInt(
                    1,
                    book.getBookId()
            );

            ps2.executeUpdate();

            System.out.println(
                    book.getTitle()
                            + " issued to "
                            + student.getStudentName()
            );

        } else {

            System.out.println(
                    "Book not available"
            );
        }
    }

    public synchronized void returnBook(
            Student student,
            Book book
    ) throws Exception {

        if (student
                .getIssuedBooks()
                .contains(book)) {

            student
                    .getIssuedBooks()
                    .remove(book);

            book.setAvailable(true);

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "UPDATE books SET available = 1 WHERE book_id = ?"
                    );

            ps.setInt(
                    1,
                    book.getBookId()
            );

            ps.executeUpdate();

            System.out.println(
                    book.getTitle()
                            + " returned by "
                            + student.getStudentName()
            );

            notify();
        }
    }
}