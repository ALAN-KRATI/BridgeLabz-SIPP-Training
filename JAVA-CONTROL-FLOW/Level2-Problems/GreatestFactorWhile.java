import java.util.*;
public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int gF = 1;
        int c = n - 1;

        while (c >= 1) {
            if (n % c == 0) {
                gF = c;
                break;
            }
            c--;
        }
        System.out.println("Greatest factor: " + gF);
    }
}
