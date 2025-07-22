package JavaProblems;
import java.util.*;

public class FlightBooking {
	static String[] availableFlights = {
			"Indigo - Mumbai to Delhi",
	        "Air India - Pune to Bangalore",
	        "SpiceJet - Chennai to Kolkata",
	        "Vistara - Delhi to Goa",
	        "GoAir - Hyderabad to Jaipur"
	};
	
	static List<String> userBooking = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Flight Booking System:");
		
		while(true) {
			System.out.println("\nMenu:");
			System.out.println("1. Search Flights");
			System.out.println("2. Book a Flight");
			System.out.println("3. View My Bookings");
			System.out.println("4. Exit");
			System.out.print("\nChoose an option: ");
			
			int chose = sc.nextInt();
			
			switch(chose) {
				case 1: 
					searchFlight();
					break;
				case 2:
					bookFlight();
					break;
				case 3:
					displayBookings();
					break;
				case 4:
					System.out.println("END!");
					return;
				default:
					System.out.println("Invalid Input.");
			}
		}
	}
	
	public static void searchFlight() {
		System.out.println();
		System.out.println("Enter search: \n");
		String s = sc.nextLine().toLowerCase();
		boolean b = false;
		
		for(String i : availableFlights) {
			if(i.toLowerCase().contains(s)) {
				System.out.println(i);
				b = true;
			}
		}
		
		if(!b) System.out.println("No Flights found!");
	}
	
	public static void bookFlight() {
		System.out.println("\nList of available Flights : \n");
		for(int i = 0; i < availableFlights.length; i++) {
			System.out.println((i + 1) + ". " + availableFlights[i]);
		}
		
		System.out.println("\nChoose a flight : ");
		int chose = sc.nextInt();
		
		if(chose > 0 && chose <= availableFlights.length) {
			String booked = availableFlights[chose - 1];
			userBooking.add(booked);
			System.out.println("\nBooked Successfully!");
		} else {
			System.out.println("\nInvalid Flight Number.");
		}
	}
	
	public static void displayBookings() {
		if(userBooking.isEmpty()) {
			System.out.println("\nNo Bookings!");
		} else {
			System.out.println("\nYour bookings are: ");
			for(String s : userBooking) {
				System.out.println("-  " + s);
			}
		}
	}
}
