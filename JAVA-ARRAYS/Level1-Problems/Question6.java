import java.util.*;
public class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int n = 10;
        int[] fact = new int[n];
        int idx = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                if (idx == n) {
                    n *= 2;
                    int[] temp = new int[n];
                    System.arraycopy(fact, 0, temp, 0, fact.length);
                    fact = temp;
                }
                fact[idx++] = i;
            }
        }
