import java.util.*;;
public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double input;

        while ((input = sc.nextDouble()) != 0) {
            total += input;
        }
        System.out.println("Total sum is: " + total);
    }
}
