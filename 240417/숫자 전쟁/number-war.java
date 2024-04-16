import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] one = new int[n+1];
        int[] two = new int[n+1]; // 남우

        for(int i=1; i<=n; i++) {
            one[i] = sc.nextInt();
        }

        for(int i=1; i<=n; i++) {
            two[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++){
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(dp[i][j] == -1){
                    continue;
                }

                if(one[i+1] < two[i+1]){
                    // 남우의 카드가 더 큰 경우-> 상대가 이김
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
                }

                if(one[i+1] > two[i+1]) {
                    dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j] + two[j+1]);
                }

                // 버리기
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]);
            }
        }

        int ans = 0;
        for(int i=0; i<=n; i++) {
            ans = Math.max(ans, dp[i][n]);
            ans = Math.max(ans, dp[n][i]);
        }

        System.out.println(ans);
    }
}