import java.util.*;
public class Question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] val = new double[10];
        double t = 0.0;
        int idx = 0;

        while (true) {
            if (idx == 10) break;
            double n = sc.nextDouble();
            if (n <= 0) break;

            val[idx++] = n;
        }

        for (int i = 0; i < idx; i++) {
            t += val[i];
            System.out.print(val[i] + " ");
        }
        System.out.println("\nSum = " + t);
    }
}
