import java.util.*;

public class Main {

    public static final int INT_MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] coin = new int[n];

        for(int i=0; i<n; i++){
            coin[i] = sc.nextInt();
        }

        int[] dp = new int[m+1];

        // 최소 동전의 수
        Arrays.fill(dp, INT_MIN);
        dp[0] = 0;


        for(int i = 1; i<=m; i++){
            for(int j = 0; j < n; j++) {

                if (i >= coin[j]) {

                    if (dp[i-coin[j]] == INT_MIN) {
                        continue;
                    }

                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }

        if (dp[m] == INT_MIN) {
            dp[m] = -1;
        }
        System.out.println(dp[m]);
    }
}