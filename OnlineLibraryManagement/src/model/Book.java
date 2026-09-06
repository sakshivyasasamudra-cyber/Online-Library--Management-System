package model;

public class Book {

    private int bookId;
    private String title;
    private boolean available = true;

    public Book(
            int bookId,
            String title,
            String author
    ) {

        this.bookId = bookId;
        this.title = title;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(
            boolean available
    ) {

        this.available = available;
    }
}