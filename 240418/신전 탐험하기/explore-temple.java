import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] room = new int[n+1][3];

        for(int i=1; i<=n; i++) {
            room[i][0] = sc.nextInt();
            room[i][1] = sc.nextInt();
            room[i][2] = sc.nextInt();
        }

        int[][] dp = new int[n+1][3];

        dp[1][0] = room[1][0];
        dp[1][1] = room[1][1];
        dp[1][2] = room[1][2];

        for(int i=2; i<=n; i++) {
            for(int j=0; j<3; j++) {
                for(int k=0; k<3; k++) {
                    if (j==k) continue;

                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + room[i][j]);
                }
            }
        }

        int ans = 0; 

        for(int i=0; i<3; i++) {
            ans = Math.max(dp[n][i], ans);
        }

        System.out.println(ans);
    }
}