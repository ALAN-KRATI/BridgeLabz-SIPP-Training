import java.util.*;
public class KmToMilesInput{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double km = sc.nextInt();
        double miles = km * 1.6;
        
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");        
    }
}