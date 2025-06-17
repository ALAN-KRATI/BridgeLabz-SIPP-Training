import java.util.*;
public class GradeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int phy = sc.nextInt();
        int chem = sc.nextInt();
        int math = sc.nextInt();
        int total = phy + chem + math;
        double percent = total / 3.0;
        System.out.println("Average Mark: " + percent);
        if (percent >= 80)
            System.out.println("Grade: A");
        else if (percent >= 70)
            System.out.println("Grade: B");
        else if (percent >= 60)
            System.out.println("Grade: C");
        else if (percent >= 50)
            System.out.println("Grade: D");
        else if (percent >= 40)
            System.out.println("Grade: E");
        else
            System.out.println("Grade: R");
    }
}