import java.util.*;
public class Handshakes{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int totalStudents = sc.nextInt();
        int totalhandshakes = (totalStudents * (totalStudents - 1)) / 2;

        System.out.println("The total number of possible handshakes is " + totalhandshakes);
    }
}