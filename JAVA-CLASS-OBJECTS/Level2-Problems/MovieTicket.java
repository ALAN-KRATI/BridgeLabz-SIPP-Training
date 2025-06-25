class MovieTicket {
    String movieName;
    int seatNumber;
    double price;

    void bookTicket(String movie, int seat, double cost) {
        movieName = movie;
        seatNumber = seat;
        price = cost;
        System.out.println("Ticket Booked!");
    }

    void displayTicketDetails() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat No: " + seatNumber);
        System.out.println("Price: ₹" + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.bookTicket("Jawan 2", 12, 250);
        ticket.displayTicketDetails();
    }
}
