import java.util.*;
public class MultiTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] table = new int[10];

        for (int i = 0; i < 10; i++) {
            table[i] = n * (i + 1);
            System.out.println(n + " * " + (i + 1) + " = " + table[i]);
        }
    }
}
