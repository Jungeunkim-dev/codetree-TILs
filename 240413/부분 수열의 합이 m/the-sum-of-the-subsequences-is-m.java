import java.util.*;

public class Main {

    public static final int INT_MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] coin = new int[n+1];

        for(int i=1; i<=n; i++){
            coin[i] = sc.nextInt();
        }

        int[] dp = new int[m+1];

        // 최소 동전의 수
        Arrays.fill(dp, INT_MIN);
        dp[0] = 0;


        
        for(int i=1; i<=n; i++) {
            for(int j=m; j>=0; j--) {
                if(j >= coin[i]) {
                    if(dp[j - coin[i]] == INT_MIN)
                        continue;
                    dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
                }
            }
        }



        if (dp[m] == INT_MIN) {
            dp[m] = -1;
        }
        System.out.println(dp[m]);
    }
}