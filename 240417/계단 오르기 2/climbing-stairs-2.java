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

        // 초기화
        dp[1][1] = coin[1];
        dp[2][0] = coin[2];
        dp[2][2] = coin[1] + coin[2];

        for(int i = 3; i<=n; i++) {
            for(int j=0; j<4; j++) {

                if(dp[i-2][j] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-2][j] + coin[i]);
                } 

                if (j > 0 && dp[i-1][j-1] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + coin[i]);
                }
            }
        }

        int ans = 0;
        
        for(int j=0; j<4; j++) {
            ans = Math.max(ans, dp[n][j]);
        }
        
        System.out.println(ans);

    }     
}