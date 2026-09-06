package main;

import database.DBConnection;
import model.Book;
import model.Student;
import service.LibraryBuffer;
import threads.LibrarianThread;
import threads.StudentThread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class LibraryDemo {

    public static void main(
            String[] args
    ) throws Exception {

        Connection con =
                DBConnection.getConnection();

        // clear tables
        con.prepareStatement(
                "DELETE FROM books"
        ).executeUpdate();

        con.prepareStatement(
                "DELETE FROM students"
        ).executeUpdate();

        con.prepareStatement(
                "DELETE FROM issued_books"
        ).executeUpdate();

        // insert books
        PreparedStatement ps1 =
                con.prepareStatement(
                        "INSERT INTO books(book_id,title,author,available) VALUES(?,?,?,?)"
                );

        ps1.setInt(1, 1);
        ps1.setString(2, "Java");
        ps1.setString(3, "Unknown");
        ps1.setBoolean(4, true);
        ps1.executeUpdate();

        ps1.setInt(1, 2);
        ps1.setString(2, "DBMS");
        ps1.setString(3, "Unknown");
        ps1.setBoolean(4, true);
        ps1.executeUpdate();

        ps1.setInt(1, 3);
        ps1.setString(2, "OS");
        ps1.setString(3, "Unknown");
        ps1.setBoolean(4, true);
        ps1.executeUpdate();

        // insert student
        PreparedStatement ps2 =
                con.prepareStatement(
                        "INSERT INTO students(student_id, student_name, student_usn, student_SEM) VALUES(?,?,?,?)"
                );

        ps2.setInt(1, 101);
        ps2.setString(2, "User");
        ps2.setString(3, "2SD23CS001");
        ps2.setInt(4, 4);

        ps2.executeUpdate();

        LibraryBuffer library =
                new LibraryBuffer();

        Book b1 =
                new Book(1, "Java","Herbert");

        Book b2 =
                new Book(2, "DBMS","Korth");

        Book b3 =
                new Book(3, "OS","Galvin");

        Student s1 =
                new Student(
                        101,
                        "User",
                        "1RV23CS001",
                        5
                );

        LibrarianThread librarian =
                new LibrarianThread();

        librarian.start();

        Scanner sc =
                new Scanner(System.in);

        while (true) {

            System.out.println(
                    "\n===== LIBRARY ====="
            );

            System.out.println("1. Java");
            System.out.println("2. DBMS");
            System.out.println("3. OS");
            System.out.println("4. Exit");

            System.out.print(
                    "Choose book: "
            );

            int choice =
                    sc.nextInt();

            if (choice == 4)
                break;

            Book selected = null;

            switch (choice) {

                case 1:
                    selected = b1;
                    break;

                case 2:
                    selected = b2;
                    break;

                case 3:
                    selected = b3;
                    break;

                default:
                    System.out.println(
                            "Invalid choice"
                    );
            }

            if (selected != null) {

                StudentThread st =
                        new StudentThread(
                                library,
                                s1,
                                selected
                        );

                st.start();

                st.join();
            }
        }

        System.out.println(
                "Library Closed."
        );
    }
}