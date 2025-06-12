import java.util.*;
public class problem3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        if(n1 > n2 && n1 > n3){
            System.out.println("Is the first number the largest? Yes.");
            System.out.println("Is the second number the largest? No.");
            System.out.println("Is the third number the largest? No.");
        } 
        else if(n2 > n1 && n2 > n3){
            System.out.println("Is the first number the largest? No.");
            System.out.println("Is the second number the largest? Yes.");
            System.out.println("Is the third number the largest? No.");
        }
        else {
            System.out.println("Is the first number the largest? No.");
            System.out.println("Is the second number the largest? No.");
            System.out.println("Is the third number the largest? Yes.");
        }
    }
}