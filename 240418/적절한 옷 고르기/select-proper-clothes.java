import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] data = new int[n+1][3];

        for(int i=1; i<=n; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            data[i][2] = sc.nextInt();
        }

        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++) { // 일수
            
            for(int j=1; j<=n; j++) {

                for(int k=1; k<=n; k++) {

                    if (data[j][0] > i || data[j][1] < i || data[k][0] > i || data[k][1] < i) {
                        continue;
                    }

                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Math.abs(data[k][2]-data[j][2]));                
                }
            }
        }

        int ans = 0;

        for(int i=1; i<=n; i++) {
            ans = Math.max(dp[m][i], ans);
        }

        System.out.println(ans);
    }
}