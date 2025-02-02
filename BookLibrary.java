class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    private double fileSize;

    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    public void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("File Size: " + fileSize + "MB");
    }
}

public class BookLibrary {
    public static void main(String[] args) {
        Book book = new Book("978-3-16-148410-0", "Effective Java", "Joshua Bloch");
        book.display();
        book.setAuthor("James Gosling");
        System.out.println("Updated Author: " + book.getAuthor());

        EBook eBook = new EBook("978-0-13-468599-1", "Java: The Complete Reference", "Herbert Schildt", 3.5);
        eBook.display();
    }
}
