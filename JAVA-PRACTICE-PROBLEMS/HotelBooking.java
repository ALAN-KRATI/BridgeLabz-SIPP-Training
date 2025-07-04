interface Bookable {
    void bookRoom();
}
abstract class Room implements Bookable {
    abstract int calculatePrice(int nights);
}
class DeluxeRoom extends Room {
    int calculatePrice(int nights) {
        return nights * 2000;
    }
    public void bookRoom() {
        System.out.println("Deluxe Room booked.");
    }
}
class SuiteRoom extends Room {
    int calculatePrice(int nights) {
        return nights * 5000;
    }
    public void bookRoom() {
        System.out.println("Suite Room booked.");
    }
}
class StandardRoom extends Room {
    int calculatePrice(int nights) {
        return nights * 1000;
    }
    public void bookRoom() {
        System.out.println("Standard Room booked.");
    }
}
class HotelBooking {
    public static void main(String[] args) {
        Room[] rooms = {
            new DeluxeRoom(),
            new SuiteRoom(),
            new StandardRoom()
        };
        for (Room r : rooms) {
            r.bookRoom();
            System.out.println("Price for 3 nights: " + r.calculatePrice(3));
        }
    }
}
