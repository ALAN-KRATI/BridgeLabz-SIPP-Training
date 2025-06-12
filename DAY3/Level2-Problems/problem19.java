import java.util.*;
public class problem19{
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       double a = sc.nextDouble();
       double b = sc.nextDouble();
       double c = sc.nextDouble();

       double w = a + b * c;
       double x = a * b + c;
       double y = c + a / b;
       double z = a % b + c;

       System.out.println("The result of Int Operations are: " + w + ", " + x + ", " + y + " and " + z);
        
    }
}