import java.util.*;
public class NumCheck{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];

        for (int i = 0; i < 5; i++) {
            num[i] = sc.nextInt();
        }

        for (int n : num) {
            if (n > 0) {
                System.out.println(n + " is positive and " + (n % 2 == 0 ? "even" : "odd"));
            } else if (n < 0) {
                System.out.println(n + " is negative");
            } else {
                System.out.println("Zero");
            }
        }

        if (num[0] > num[4]) {
            System.out.println("First element is greater than last");
        } else if (num[0] < num[4]) {
            System.out.println("First element is less than last");
        } else {
            System.out.println("First and last elements are equal");
        }
    }
}
