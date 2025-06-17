import java.util.*;
public class YoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age and height of Amar: ");
        int age1 = sc.nextInt();
        double height1 = sc.nextDouble();
        System.out.print("Enter age and height of Akbar: ");
        int age2 = sc.nextInt();
        double height2 = sc.nextDouble();
        System.out.print("Enter age and height of Anthony: ");
        int age3 = sc.nextInt();
        double height3 = sc.nextDouble();

        String youngest = "Amar";
        int minAge = age1;
        if (age2 < minAge) {
            youngest = "Akbar";
            minAge = age2;
        }
        if (age3 < minAge) {
            youngest = "Anthony";
        }
        String tallest = "Amar";
        double maxHeight = height1;
        if (height2 > maxHeight) {
            tallest = "Akbar";
            maxHeight = height2;
        }
        if (height3 > maxHeight) {
            tallest = "Anthony";
        }

        System.out.println("Youngest friend is: " + youngest);
        System.out.println("Tallest friend is: " + tallest);
    }
}
