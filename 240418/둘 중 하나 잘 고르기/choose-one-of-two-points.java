import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] red = new int[2*n+1];
        int[] blue = new int[2*n+1];

        for(int i=1; i<=2*n; i++) {
            red[i] = sc.nextInt();
            blue[i] = sc.nextInt();
        }

        int ans = Integer.MIN_VALUE;

        int[][] dp = new int[2*n+1][2*n+1];
        
        
        for(int i=0; i<=2*n; i++) {
            for(int j=0; j<=2*n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        
        
        dp[0][0] = 0;

        for(int i=1; i<=2*n; i++) {
            for(int j=0; j<=i; j++) {

                if (j>0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + red[i]); 
                }

                if (i-j>0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + blue[i]);
                }
            }
        }

        System.out.println(dp[2*n][n]);
    }
}