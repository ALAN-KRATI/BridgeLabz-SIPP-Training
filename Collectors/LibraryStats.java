import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    String genre;
    int pages;
    Book(String title, String genre, int pages) {
        this.title = title; this.genre = genre; this.pages = pages;
    }
    public String getGenre() { return genre; }
    public int getPages() { return pages; }
}

public class LibraryStats {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book1", "Fiction", 300),
            new Book("Book2", "Fiction", 250),
            new Book("Book3", "Science", 400),
            new Book("Book4", "Science", 350),
            new Book("Book5", "History", 200)
        );
        Map<String, IntSummaryStatistics> stats = books.stream()
            .collect(Collectors.groupingBy(Book::getGenre, Collectors.summarizingInt(Book::getPages)));
        stats.forEach((genre, summary) -> System.out.println(genre + " -> " + summary));
    }
}
