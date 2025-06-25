class Circle {
    double radius;

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    void displayDetails() {
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        c.radius = 7;
        c.displayDetails();
    }
}
