package main;

import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LibraryReport {

    public static void showBooks() {

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM books"
                    );

            System.out.println("\n===== BOOK DETAILS =====");

            while (rs.next()) {

                System.out.println(
                        "Book ID : "
                                + rs.getInt("book_id")
                );

                System.out.println(
                        "Title : "
                                + rs.getString("title")
                );

                System.out.println(
                        "Author : "
                                + rs.getString("author")
                );

                System.out.println(
                        "Available : "
                                + (rs.getInt("available") == 1
                                ? "Yes"
                                : "No")
                );

                System.out.println("-------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showStudents() {

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM students"
                    );

            System.out.println(
                    "\n===== STUDENT DETAILS ====="
            );

            while (rs.next()) {

                System.out.println(
                        "Student ID : "
                                + rs.getInt("student_id")
                );

                System.out.println(
                        "Student Name : "
                                + rs.getString("student_name")
                );

                System.out.println("-------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showIssuedBooks() {

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM issued_books"
                    );

            System.out.println(
                    "\n===== ISSUE DETAILS ====="
            );

            while (rs.next()) {

                System.out.println(
                        "Issue ID : "
                                + rs.getInt("issue_id")
                );

                System.out.println(
                        "Student ID : "
                                + rs.getInt("student_id")
                );

                System.out.println(
                        "Book ID : "
                                + rs.getInt("book_id")
                );

                System.out.println(
                        "Issue Date : "
                                + rs.getDate("issue_date")
                );

                System.out.println(
                        "Return Date : "
                                + rs.getDate("return_date")
                );

                System.out.println(
                        "Fine : "
                                + rs.getDouble("fine")
                );

                System.out.println("-------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        showBooks();

        showStudents();

        showIssuedBooks();
    }
}