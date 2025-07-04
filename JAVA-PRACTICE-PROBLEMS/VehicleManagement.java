class Vehicle {
    String brand, model, fuelType;
    Vehicle(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }
    void printServiceDetails() {
        System.out.println("Generic Vehicle Service");
    }
}
class Car extends Vehicle {
    Car(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }
    void printServiceDetails() {
        System.out.println("Car Service Cost: $200");
    }
}
class Bike extends Vehicle {
    Bike(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }
    void printServiceDetails() {
        System.out.println("Bike Service Cost: $100");
    }
}
class Truck extends Vehicle {
    Truck(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }
    void printServiceDetails() {
        System.out.println("Truck Service Cost: $300");
    }
}
class VehicleManagement {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Honda", "City", "Petrol"),
            new Bike("Yamaha", "FZ", "Petrol"),
            new Truck("Tata", "LPT", "Diesel")
        };
        for (Vehicle v : vehicles) {
            v.printServiceDetails();
        }
    }
}
