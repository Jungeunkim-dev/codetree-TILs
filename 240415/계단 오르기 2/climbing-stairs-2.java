import java.util.*;

public class Main {

    public static final int INT_MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        int n = sc.nextInt();
        int[] coin = new int[n+1];

        for(int i=1; i<=n; i++) {
            coin[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][4];

        for(int i = 1; i<=n; i++) {
            for(int j=0; j<4; j++) {
                dp[i][j] = INT_MIN;
            }
        }

        
        dp[1][0] = coin[1];
        dp[1][1] = 0;
        dp[1][2] = 0;
        dp[1][3] = 0;
    


        for(int i = 3; i<=n; i++) {
            for(int j=0; j<4; j++) {

                if (i == n) {
                    dp[i][j] = dp[i-1][j-1];
                }

                dp[i][j] = Math.max(dp[i-2][j], dp[i-1][j-1]) + coin[i];
            }
        }

        int ans = INT_MIN; 

        for(int i=0;i<4;i++){
            if (dp[n][i] > ans) {
                ans = dp[n][i];
            }
        }

        System.out.println(ans);
    }
}