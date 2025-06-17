import java.util.*;
public class OddEvenSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number.");
            return;
        }

        int[] e = new int[n / 2 + 1];
        int[] o = new int[n / 2 + 1];
        int eIdx = 0, oIdx = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                e[eIdx++] = i;
            } else {
                o[oIdx++] = i;
            }
        }

        System.out.print("Even numbers: ");
        for (int i = 0; i < eIdx; i++) {
            System.out.print(e[i] + " ");
        }

        System.out.print("\nOdd numbers: ");
        for (int i = 0; i < oIdx; i++) {
            System.out.print(o[i] + " ");
        }
    }
}
