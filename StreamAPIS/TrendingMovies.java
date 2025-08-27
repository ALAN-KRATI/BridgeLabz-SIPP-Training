import java.util.*;
import java.util.stream.*;

class Movie {
    String title;
    double rating;
    int year;
    Movie(String title, double rating, int year) {
        this.title = title; this.rating = rating; this.year = year;
    }
    public String toString() { return title + " | " + rating + " | " + year; }
}

public class TrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("A", 8.5, 2023),
            new Movie("B", 9.0, 2022),
            new Movie("C", 7.9, 2023),
            new Movie("D", 9.5, 2021),
            new Movie("E", 8.8, 2023),
            new Movie("F", 9.1, 2023),
            new Movie("G", 7.5, 2022)
        );
        movies.stream()
              .sorted(Comparator.comparingDouble((Movie m) -> m.rating).reversed()
              .thenComparing(m -> m.year, Comparator.reverseOrder()))
              .limit(5)
              .forEach(System.out::println);
    }
}
