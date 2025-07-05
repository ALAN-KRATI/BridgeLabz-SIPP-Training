class Movie {
    String title;
    String director;
    int year;
    float rating;
    Movie next, prev;

    public Movie(String title, String director, int year, float rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = this.prev = null;
    }
}

public class MovieManager {
    Movie head = null, tail = null;

    public void addAtBeginning(String title, String director, int year, float rating) {
        Movie movie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = movie;
            return;
        }
        movie.next = head;
        head.prev = movie;
        head = movie;
    }

    public void addAtEnd(String title, String director, int year, float rating) {
        Movie movie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = movie;
            return;
        }
        tail.next = movie;
        movie.prev = tail;
        tail = movie;
    }

    public void addAtPosition(int pos, String title, String director, int year, float rating) {
        if (pos <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie movie = new Movie(title, director, year, rating);
        Movie temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        movie.next = temp.next;
        movie.prev = temp;
        temp.next.prev = movie;
        temp.next = movie;
    }

    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equals(title))
            temp = temp.next;
        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }
        if (temp == head)
            head = temp.next;
        if (temp == tail)
            tail = temp.prev;
        if (temp.prev != null)
            temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    public void searchByDirectorOrRating(String director, float rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equals(director) || temp.rating == rating) {
                System.out.println("Movie: " + temp.title + " | Dir: " + temp.director + " | Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No matching records found.");
    }

    public void updateRating(String title, float newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public void displayForward() {
        Movie temp = head;
        System.out.println("Forward Movie List:");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Movie temp = tail;
        System.out.println("Reverse Movie List:");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        MovieManager mm = new MovieManager();
        mm.addAtEnd("Inception", "Nolan", 2010, 9.0f);
        mm.addAtBeginning("Jawan", "Atlee", 2023, 8.2f);
        mm.addAtPosition(2, "Dunki", "Hirani", 2023, 8.5f);
        mm.displayForward();
        mm.updateRating("Jawan", 9.1f);
        mm.removeByTitle("Dunki");
        mm.displayReverse();
        mm.searchByDirectorOrRating("Nolan", 9.1f);
    }
}
