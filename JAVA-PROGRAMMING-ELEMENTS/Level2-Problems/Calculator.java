import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        double height = sc.nextDouble();

        double areaInInches = 0.5 * base * height;
        double areaInCm = areaInInches * 6.4516;

        double heightInCm = height * 2.54;
        double heightInFeet = height / 12;
        double heightInInches = height;

        System.out.println("Your Height in cm is " + heightInCm + " while in feet is " + heightInFeet + " and inches is " + heightInInches);
        System.out.println("Area of Triangle: " + areaInInches + " square inches and " + areaInCm + " square centimeters");
    }
}
