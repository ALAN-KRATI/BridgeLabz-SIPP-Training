import java.util.*;
public class Digit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int size = 10;
        int[] d = new int[size];
        int idx = 0;

        while (n != 0 && idx < size) {
            d[idx++] = n % 10;
            n /= 10;
        }

        int largest = -1, second = -1;
        for (int i = 0; i < idx; i++) {
            if (d[i] > largest) {
                second = largest;
                largest = d[i];
            } else if (d[i] > second && d[i] != largest) {
                second = d[i];
            }
        }

        System.out.println(largest);
        System.out.println(second);
    }
}
