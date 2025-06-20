import java.util.*;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }
}

public class LibrarySearch {
    static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "Data Structures", "Balagurusamy"),
            new Book(102, "Operating Systems", "Galvin"),
            new Book(103, "Computer Networks", "Tanenbaum")
        };

        Arrays.sort(books, Comparator.comparing(b -> b.title));

        System.out.println("Binary Search for 'Operating Systems':");
        Book found = binarySearch(books, "Operating Systems");
        if (found != null)
            System.out.println("Found: " + found.title + " by " + found.author);
        else
            System.out.println("Book not found.");

        System.out.println("\nLinear Search for 'Data Structures':");
        found = linearSearch(books, "Data Structures");
        if (found != null)
            System.out.println("Found: " + found.title + " by " + found.author);
        else
            System.out.println("Book not found.");
    }
}
