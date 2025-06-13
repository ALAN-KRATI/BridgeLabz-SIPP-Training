import java.util.*;
public class problem17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int salary = sc.nextInt();
        int years = sc.nextInt();

        if (years > 5) {
            double bonus = 0.05 * salary;
            System.out.println("Bonus is: " + bonus);
        } else {
            System.out.println("No bonus.");
        }
    }
}
