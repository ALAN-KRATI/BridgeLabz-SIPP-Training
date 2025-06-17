import java.util.*;
public class FactorsFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n > 0) {
            System.out.println("Factors:");
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Invalid input.");
        }
    }
}
