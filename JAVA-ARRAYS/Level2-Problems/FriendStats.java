import java.util.Scanner;
public class FriendStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
            heights[i] = sc.nextDouble();
        }

        int youngest = 0;
        int tallest = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngest]) youngest = i;
            if (heights[i] > heights[tallest]) tallest = i;
        }

        System.out.println("Youngest: " + names[youngest]);
        System.out.println("Tallest: " + names[tallest]);
    }
}
