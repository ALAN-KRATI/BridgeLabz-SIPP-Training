abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

interface Reservable {
    boolean reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public boolean reserveItem() {
        return true;
    }

    public boolean checkAvailability() {
        return true;
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public boolean reserveItem() {
        return true;
    }

    public boolean checkAvailability() {
        return true;
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public boolean reserveItem() {
        return true;
    }

    public boolean checkAvailability() {
        return true;
    }
}

public class librarySystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B001", "1984", "George Orwell"),
            new Magazine("M001", "Forbes", "Steve"),
            new DVD("D001", "Inception", "Nolan")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration (days): " + item.getLoanDuration());
            if (item instanceof Reservable) {
                System.out.println("Available: " + ((Reservable) item).checkAvailability());
            }
            System.out.println();
        }
    }
}
