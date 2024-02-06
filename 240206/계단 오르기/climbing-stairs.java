import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];

        if (n <= 3){
            System.out.println(1);
        } else {

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<=n; i++) {
            dp[i] = (dp[i-2] + dp[i-3])%10007;
        }

        System.out.println(dp[n]);
        }
    }
}