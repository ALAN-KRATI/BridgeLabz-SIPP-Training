import java.util.*;
public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] phy = new int[n];
        int[] chem = new int[n];
        int[] math = new int[n];
        double[] perc = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; ) {
            phy[i] = sc.nextInt();
            chem[i] = sc.nextInt();
            math[i] = sc.nextInt();

            if (phy[i] < 0 || chem[i] < 0 || math[i] < 0) {
                System.out.println("Marks can't be negative. Re-enter.");
                continue;
            }

            perc[i] = (phy[i] + chem[i] + math[i]) / 3.0;

            if (perc[i] >= 90) grade[i] = 'A';
            else if (perc[i] >= 80) grade[i] = 'B';
            else if (perc[i] >= 70) grade[i] = 'C';
            else if (perc[i] >= 60) grade[i] = 'D';
            else grade[i] = 'F';
            i++;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": " + "Physics = " + phy[i] +
                    ", Chemistry = " + chem[i] + ", Maths = " + math[i] +
                    ", Percentage = " + perc[i] + "%, Grade = " + grade[i]);
        }
    }
}
