import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] data = new int[n+1];

        for(int i=1; i<=n; i++) {
            data[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            dp[i] = data[i];
        }

        for(int i=1; i<=n; i++) {
            dp[i] = Math.max(dp[i], dp[i-1] + data[i]);
        }

        Arrays.sort(dp);

        System.out.println(dp[n]);
    }
}