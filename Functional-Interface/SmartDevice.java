interface Device {
    void turnOn();
    void turnOff();
}

class Light implements Device {
    public void turnOn() { System.out.println("Light turned on"); }
    public void turnOff() { System.out.println("Light turned off"); }
}

class AC implements Device {
    public void turnOn() { System.out.println("AC turned on"); }
    public void turnOff() { System.out.println("AC turned off"); }
}

class TV implements Device {
    public void turnOn() { System.out.println("TV turned on"); }
    public void turnOff() { System.out.println("TV turned off"); }
}

public class SmartDeviceDemo {
    public static void main(String[] args) {
        Device d1 = new Light();
        Device d2 = new AC();
        Device d3 = new TV();
        d1.turnOn(); d1.turnOff();
        d2.turnOn(); d2.turnOff();
        d3.turnOn(); d3.turnOff();
    }
}
