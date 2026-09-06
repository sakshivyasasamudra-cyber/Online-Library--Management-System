package model;

import java.util.ArrayList;

public class Student {

    private int studentId;
    private String studentName;
    private String studentUsn;
    private int studentSem;

    ArrayList<Book> issuedBooks =
            new ArrayList<>();

    public Student(
            int studentId,
            String studentName,
            String studentUsn,
            int studentSem
    ) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.studentUsn = studentUsn;
        this.studentSem = studentSem;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentUsn() {
        return studentUsn;
    }

    public int getStudentSem() {
        return studentSem;
    }

    public ArrayList<Book> getIssuedBooks() {
        return issuedBooks;
    }
}