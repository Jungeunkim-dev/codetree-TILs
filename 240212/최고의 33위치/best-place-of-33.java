import java.util.*;

public class Main {

    static int n;

    static int[][] grid;
    static int max_count = 0; // 격자 내 들어올 수 있는 최대 동전의 수

    public static void updateMax(int sx, int sy) {

        int sum = 0;

        if (sx + 2 >= n || sy + 2 >= n) {
            return;
        }

        for(int i=0;i<3; i++){
            for(int j=0; j<3; j++){
                sum+=grid[sx+i][sy+j];
            }
        }

        max_count = Math.max(sum, max_count);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        grid = new int[n][n];

        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<=n-1;i++){
            for(int j=0; j<=n-1; j++){
                updateMax(i,j);
            }
        }

        System.out.println(max_count);
    }
}