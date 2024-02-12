import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] grid;
    static int max = 0;

    static int[][][] moves = {
        {{-1,0},{0,1}},
        {{-1,0},{0,-1}},
        {{1,0},{0,-1}},
        {{1,0},{0,1}},
        {{0,-1},{0,1}},
        {{1,0},{-1,0}}
    };

    public static void getSum(int cx, int cy){

        int count = 0; 

        for (int i=0; i<6; i++) {

            count += grid[cx][cy];

            for(int j=0; j<2; j++) {

                int nx = cx + moves[i][j][0];
                int ny = cy + moves[i][j][1];

                if(nx<0 || nx >= n || ny <0 || ny >= m) {
                    continue;
                }

                count += grid[nx][ny];
            }

            max = Math.max(count, max);
            count = 0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];

        for(int i=0;i<n; i++){
            for(int j=0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                getSum(i,j);
            }
        }

        System.out.println(max);
    }
}