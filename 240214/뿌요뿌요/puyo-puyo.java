import java.util.*;

public class Main {
    
    static int n;
    static int[][] grid;
    static boolean[][] visited;

    static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};

    static int explode_count = 0;
    static int max_area = 0;
    static int areaSize = 1;
    static int areaNum;

    public static void DFS(int cnt, int x, int y) {

        for(int i=0; i<4; i++) {
            int nx = move[i][0] + x;
            int ny = move[i][1] + y;

            if(0<=nx && nx<n && 0<=ny && ny <n && !visited[nx][ny]) {

                if(grid[nx][ny] == areaNum) {
                    visited[nx][ny] = true;
                    areaSize++;
                    DFS(cnt+1, nx, ny);
                }
            }
        }
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0;j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }


        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]){
                    areaSize = 1;
                    visited[i][j] = true;
                    areaNum = grid[i][j];

                    DFS(0,i,j);
                    max_area = Math.max(areaSize, max_area);

                    if(areaSize >= 4) {
                        explode_count++;
                    }
                }
            }
        }

        System.out.print(explode_count+" ");
        System.out.print(max_area);
    }
}