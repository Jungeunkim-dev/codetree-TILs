import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static boolean[] column;
    static int max_value = 0;
    static int temp = 0;

    public static void choose(int r) {
        
        // 종료조건 
        if (r == n) {
            max_value = Math.max(max_value, temp);
            return;
        }

        for(int i=0; i<n; i++) {
            
            if (column[i] == false) {
                column[i] = true;
                temp += grid[r][i];

                choose(r+1);

                column[i] = false;
                temp -= grid[r][i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        column = new boolean[n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        choose(0);

        System.out.println(max_value);
    }
}