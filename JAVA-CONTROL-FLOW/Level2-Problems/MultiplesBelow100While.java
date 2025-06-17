import java.util.*;
public class MultiplesBelow100While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n > 0 && n < 100) {
            int c = 100;
            while (c >= 1) {
                if (c % n == 0) {
                    System.out.println(c);
                }
                c--;
            }
        } else {
            System.out.println("Invalid input.");
        }
    }
}
