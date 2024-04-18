import java.util.*;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[][] dp = new long[n+1][15];

        for(int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }

        // 0으로 시작하는 

        // for(int i=2; i<=n; i++) {

        //     for(int j=0; j<=9; j++) {
                
        //         if (j==0) dp[i][j] = dp[i][1] + 1;
        //         if (j==9) dp[i][j] = dp[i][8] + 1;

        //         if (j>0 && j<9) {
                    
        //             dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
        //         }
        //     }
        // }

        for(int i=1; i<n; i++) {
            for(int j=0; j<=9; j++) {

                if (j > 0) {
                    dp[i+1][j-1] = (dp[i+1][j-1] + dp[i][j]) % MOD;
                }

                if (j < 9) {
                    dp[i+1][j+1] = (dp[i+1][j+1] + dp[i][j]) % MOD;
                }
            }
        }

        long ans = 0;

        for(int i=0; i<=9; i++) {
            ans = (ans + dp[n][i]) % 1000000007;
        }

        System.out.println(ans);
    }
}