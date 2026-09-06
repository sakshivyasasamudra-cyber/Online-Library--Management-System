package threads;

import model.Book;
import model.Student;
import service.LibraryBuffer;

public class StudentThread
        extends Thread {

    LibraryBuffer library;
    Student student;
    Book book;

    public StudentThread(
            LibraryBuffer library,
            Student student,
            Book book
    ) {

        this.library = library;
        this.student = student;
        this.book = book;
    }

    @Override
    public void run() {

        try {

            library.issueBook(
                    student,
                    book
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}