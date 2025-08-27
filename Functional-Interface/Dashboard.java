interface VehicleDashboard {
    void displaySpeed();
    default void displayBattery() { System.out.println("Battery at 80%"); }
}

class PetrolCar implements VehicleDashboard {
    public void displaySpeed() { System.out.println("Speed: 60 km/h"); }
}

class ElectricCar implements VehicleDashboard {
    public void displaySpeed() { System.out.println("Speed: 50 km/h"); }
}

public class DashboardDemo {
    public static void main(String[] args) {
        VehicleDashboard v1 = new PetrolCar();
        VehicleDashboard v2 = new ElectricCar();
        v1.displaySpeed();
        v2.displaySpeed();
        v2.displayBattery();
    }
}
