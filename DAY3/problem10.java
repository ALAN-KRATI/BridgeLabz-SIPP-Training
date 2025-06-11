import java.util.*;

public class problem10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double height = sc.nextDouble();
        double inchesTotal = height / 2.54;
        int feet = (int) (inchesTotal / 12);
        double inches = inchesTotal % 12;
        System.out.println("Your Height in cm is " + height + " while in feet is " + feet + " and inches is " + inches);
    }
}
