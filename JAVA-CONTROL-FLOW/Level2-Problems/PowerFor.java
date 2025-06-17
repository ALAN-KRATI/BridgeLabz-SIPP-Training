import java.util.*;
public class PowerFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        if (n >= 0 && p >= 0) {
            int res = 1;
            for (int i = 1; i <= p; i++) {
                res *= n;
            }
            System.out.println("Result: " + res);
        } else {
            System.out.println("Only positive integers allowed.");
        }
 
    }
}
