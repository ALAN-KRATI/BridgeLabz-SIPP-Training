import java.util.*;
public class problem29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        if (n >= 0 && p >= 0) {
            int res = 1;
            int c = 0;

            while (c < p) {
                res *= n;
                c++;
            }
            System.out.println("Result: " + res);
        } else {
            System.out.println("Only positive integers are allowed.");
        }
    }
}
