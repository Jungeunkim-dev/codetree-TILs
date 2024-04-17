import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] num = new int[n+1];

        for(int i=1; i<=n; i++) {
            num[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][k+1];

        int ans = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++) {

            if (num[i] >= 0) {
                
                for(int j=0; j<=k; j++) {
                    dp[i][j] = Math.max(dp[i-1][j] + num[i], num[i]);
                    ans = Math.max(ans, dp[i][j]);
                }
            } else {

                for(int j=1; j <= k; j++) {
                    dp[i][j] = Math.max(dp[i-1][j-1] + num[i], num[i]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        
        System.out.println(ans);
    }
}