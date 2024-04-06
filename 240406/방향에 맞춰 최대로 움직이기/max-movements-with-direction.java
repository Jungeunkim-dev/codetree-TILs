import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static int[][] direction;
    static int[][] delta = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
    static int max_count = 0;

    public static void choose(int cx, int cy, int count) {

        max_count = Math.max(max_count, count);

        int moveX = delta[direction[cx][cy]][0];
        int moveY = delta[direction[cx][cy]][1];

        for(int i=0; i<n; i++) {
            int nx = cx + moveX * (i+1);
            int ny = cy + moveY * (i+1);

            if (nx<0 || nx>=n || ny<0 || ny>=n) {
                continue;
            }

            if(grid[nx][ny] > grid[cx][cy]) {
                choose(nx, ny, count+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        direction = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<n; i++){
            for(int j=0;j<n;j++){
                direction[i][j] = sc.nextInt()-1; // 배열 인덱스를 맞춰 주기 위해 -1 처리
            }
        }

        int sx = sc.nextInt()-1;
        int sy = sc.nextInt()-1;

        choose(sx, sy, 0);

        System.out.println(max_count);
    }
}