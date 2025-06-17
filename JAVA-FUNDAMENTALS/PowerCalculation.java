import java.util.*;
public class PowerCalculation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int e = sc.nextInt();
        int ans = 1;

        for(int i = 1; i <= e; i++){
            ans *= b;
        }

        System.out.println(ans);        
    }
}