import java.util.*;
public class DynamicDigitMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int t = n;
        int c = 0;
        while (t != 0) {
            t /= 10;
            c++;
        }

        int[] d = new int[c];
        t = n;
        for (int i = 0; i < c; i++) {
            d[i] = t % 10;
            t /= 10;
        }

        for (int i = 0; i < c; i++) {
            System.out.println(d[i]);
        }
    }
}
