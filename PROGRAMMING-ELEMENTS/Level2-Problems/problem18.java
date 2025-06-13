import java.util.*;
public class problem18{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();
       int c = sc.nextInt();

       int w = a + b * c;
       int x = a * b + c;
       double y = c + a / b;
       int z = a % b + c;

       System.out.println("The result of Int Operations are: " + w + ", " + x + ", " + y + " and " + z);
        
    }
}