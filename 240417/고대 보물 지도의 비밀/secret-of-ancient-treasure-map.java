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

        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            dp[i] = num[i];
        }

        int minusCount = 0;

        for(int i=1; i<=n; i++) {

            if (minusCount>k && num[i] < 0) {
                continue;
            }

            dp[i] = Math.max(dp[i], dp[i-1]+num[i]);

            if(num[i] < 0) {
                minusCount++;
            }
        }

        int ans = 0;

        for(int i=1; i<=n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(Arrays.toString(dp));

        System.out.println(ans);
    }
}