import java.util.*;

public class Main {

    static char[][] grid;
    static int n;
    static List<Integer> arr = new ArrayList<>();
    static int[][] delta = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    static int min_move = Integer.MAX_VALUE;
    static boolean[][] visited;


    public static boolean checkIfNumeric(int nx, int ny) {

            int value = (int) (grid[nx][ny] - '0');

            if (!arr.isEmpty()) {
                if (arr.get(arr.size()-1) < value) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
    

    public static void move(int cx, int cy, int count) {

        if (grid[cx][cy] == 'E') {
            if (arr.size() >= 3) {
                min_move = Math.min(min_move, count);
            }
            
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = cx + delta[i][0];
            int ny = cy + delta[i][1];

            if (0<=nx && nx<n && 0<=ny && ny<n && visited[nx][ny]==false) {

                if (grid[nx][ny] == '.' || grid[nx][ny] == 'S' || grid[nx][ny] == 'E') {

                    visited[nx][ny] = true;
                    move(nx, ny, count+1);
                    visited[nx][ny] = false;

                } else {
                    if(checkIfNumeric(nx,ny)) {
                        visited[nx][ny] = true;
                        arr.add((int)grid[nx][ny] - '0');
                        move(nx, ny, count+1);
                        visited[nx][ny] = false;
                        arr.remove(arr.size()-1);
                    }
                } 
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        grid = new char[n][n];
        visited = new boolean[n][n];

        int sx = 0;
        int sy = 0;

        for(int i=0; i<n; i++) {
            String input = sc.next();
            for(int j=0; j<n; j++) {
                grid[i][j] = input.charAt(j);

                if(grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }

        visited[sx][sy]=true;
        move(sx, sy, 0);

        if(min_move >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min_move);
        }
    }
}