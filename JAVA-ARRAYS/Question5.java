import java.util.*;
public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c= sc.nextInt();

        int[][] arr = new int[r][c];
        int[] arr1 = new int[r * c];
        int idx = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
                arr1[idx++] = arr[i][j];
            }
        }

        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}
