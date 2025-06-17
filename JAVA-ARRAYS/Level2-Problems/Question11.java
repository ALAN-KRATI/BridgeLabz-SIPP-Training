import java.util.*;
public class Question11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalaries = new double[10];
        double totalBonus = 0, totalOld = 0, totalNew = 0;

        for (int i = 0; i < 10; ) {
            double s = sc.nextDouble();
            double y = sc.nextDouble();

            if (s <= 0 || y < 0) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            salaries[i] = s;
            years[i] = y;
            i++;
        }

        for (int i = 0; i < 10; i++) {
            if (years[i] > 5) {
                bonus[i] = salaries[i] * 0.05;
            } else {
                bonus[i] = salaries[i] * 0.02;
            }
            newSalaries[i] = salaries[i] + bonus[i];
            totalBonus += bonus[i];
            totalOld += salaries[i];
            totalNew += newSalaries[i];
        }

        System.out.println("Total Bonus = " + totalBonus);
        System.out.println("Total Old Salary = " + totalOld);
        System.out.println("Total New Salary = " + totalNew);
    }
}
