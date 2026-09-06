package threads;

public class LibrarianThread
        extends Thread {

    @Override
    public void run() {

        System.out.println(
                "Librarian is monitoring issue/return operations..."
        );
    }
}