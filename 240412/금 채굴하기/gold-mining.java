import java.util.*;

public class Main {

    static int n,m;
    static int K_MAX;
    static int GOLD_MAX = 0;
    static int[][] grid;

    public static void mine(int k, int cx, int cy) {

        int gold = 0;

        for(int i = cx-k; i <= cx+k; i++) {
            for(int j = cy-k; j <= cy+k; j++) {

                if (0<=i && i<n && 0<=j && j<n) {
                    if (Math.abs(cx - i) + Math.abs(cy - j) <= k) {
                        gold += grid[i][j];
                    }
                }
            }
        }

        int costValue = k*k + (k+1) * (k+1);
        int goldValue = gold * (m);
        
        if(goldValue >= costValue) {
            GOLD_MAX = Math.max(GOLD_MAX, gold);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        K_MAX = n*2 - 1;

        grid = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for(int k=0; k<=K_MAX; k++) {

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    mine(k, i, j);
                }
            }
        }

        System.out.println(GOLD_MAX);
    }
}