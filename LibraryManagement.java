import java.util.*;
class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display(){
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    String name;
    ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            book.display();
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner adi= new Scanner(System.in);

        System.out.print("Enter library name: ");
        String libraryName = adi.nextLine();
        Library library = new Library(libraryName);

        System.out.print("Enter number of books: ");
        int numBooks = adi.nextInt();
        adi.nextLine();

        for (int i = 0; i < numBooks; i++) {
            System.out.print("Enter book title: ");
            String title =adi.nextLine();
            System.out.print("Enter book author: ");
            String author= adi.nextLine();
            Book book = new Book(title, author);
            library.addBook(book);
        }

        System.out.println();
        library.displayBooks();
        adi.close();
    }
}