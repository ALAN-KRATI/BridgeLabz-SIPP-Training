import java.util.*;
public class problem23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n > 0) {
            int i = 1;
            System.out.println("Factors:");
            while (i < n) {
                if (n % i == 0) {
                    System.out.println(i);
                }
                i++;
            }
        } else {
            System.out.println("Invalid input.");
        }
    }
}
