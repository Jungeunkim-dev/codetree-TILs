import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        int n = sc.nextInt();
        int kMax = sc.nextInt();

        String jem = sc.next();

        int[][][] dp = new int[n+1][2][kMax+1];
        
        char[] pos = {'L','R'};

        // 0:L, 1:R

        if(jem.charAt(0)=='L') {
            dp[1][0][0] = 1;
        }


        if(jem.charAt(0)=='R') {
            dp[1][1][0] = 1;
        }

        for(int i=2; i<=n; i++) {

            for(int j=0; j<2; j++) {

                for(int k=0; k <= kMax; k++) {

                    if (k > i-1) continue;
                    
                    if (k==0) {
                        dp[i][j][0] = dp[i-1][j][0];
                    
                    } else {

                        int value = jem.charAt(i-1)=='L' ? 0 : 1;
                        int count = 0;

                        if (j == value) {
                            count = 1;
                        }

                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][ (j+1) % 2][k-1]) + count;
                    }
                }

            }
        }

        int ans = 0;

        for(int i=0; i<2; i++) {
            for(int k=0; k<=kMax; k++) {
                ans = Math.max(ans, dp[n][i][k]);
            }
        }

        System.out.println(ans);
    }
}