import java.util.*;
public class SquareFromPerimeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double distanceInFeet = sc.nextDouble();

        double distanceInYards = distanceInFeet / 3;
        double distanceInMiles = distanceInYards / 1760;


        System.out.println("Distance is " + distanceInYards + " yards and " + distanceInMiles + " miles while in feet is " + distanceInFeet);
    }
}
