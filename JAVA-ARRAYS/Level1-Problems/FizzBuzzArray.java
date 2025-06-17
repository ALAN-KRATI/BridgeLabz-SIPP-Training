import java.util.*;
public class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num <= 0) {
            System.out.println("Number must be positive.");
            return;
        }

        String[] res = new String[num + 1];

        for (int i = 0; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                res[i] = "Fizz";
            } else if (i % 5 == 0) {
                res[i] = "Buzz";
            } else {
                res[i] = Integer.toString(i);
            }
        }

        for (int i = 1; i <= num; i++) {
            System.out.println("Position " + i + " = " + res[i]);
        }
    }
}
