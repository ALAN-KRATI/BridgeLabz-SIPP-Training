import java.util.*;
public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] perc = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; ) {
            marks[i][0] = sc.nextInt();
            marks[i][1] = sc.nextInt();
            marks[i][2] = sc.nextInt();

            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Invalid marks. Try again.");
                continue;
            }

            perc[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (perc[i] >= 90) grade[i] = 'A';
            else if (perc[i] >= 80) grade[i] = 'B';
            else if (perc[i] >= 70) grade[i] = 'C';
            else if (perc[i] >= 60) grade[i] = 'D';
            else grade[i] = 'F';

            i++;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": Physics = " + marks[i][0] +
                    ", Chemistry = " + marks[i][1] + ", Maths = " + marks[i][2] +
                    ", Percentage = " + perc[i] + "%, Grade = " + grade[i]);
        }
    }
}
