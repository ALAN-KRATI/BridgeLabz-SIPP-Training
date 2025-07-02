// File: vehicleRentalSystem.java

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicy;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 5000; // flat rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (Policy No. Hidden)";
    }
}

class Bike extends Vehicle implements Insurable {
    private String insurancePolicy;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 1500; // flat rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance (Policy No. Hidden)";
    }
}

class Truck extends Vehicle implements Insurable {
    private String insurancePolicy;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicy) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 2000; // extra handling charges
    }

    @Override
    public double calculateInsurance() {
        return 8000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (Policy No. Hidden)";
    }
}

public class vehicleRentalSystem {
    public static void processVehicles(Vehicle[] vehicles, int days) {
        for (Vehicle v : vehicles) {
            double rental = v.calculateRentalCost(days);
            double insurance = 0;

            if (v instanceof Insurable) {
                insurance = ((Insurable) v).calculateInsurance();
                System.out.println(((Insurable) v).getInsuranceDetails());
            }

            System.out.println("Vehicle: " + v.getType() + " | No: " + v.getVehicleNumber());
            System.out.println("Rental for " + days + " days: " + rental);
            System.out.println("Insurance: " + insurance);
            System.out.println("Total Cost: " + (rental + insurance));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car("DL01AB1234", 2000, "CAR123456"),
            new Bike("DL02XY9876", 800, "BIKE234567"),
            new Truck("DL03TR5678", 5000, "TRUCK345678")
        };

        processVehicles(fleet, 3); // 3-day rentals
    }
}