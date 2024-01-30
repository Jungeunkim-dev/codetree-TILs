import java.util.*;

public class Main {

    public static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    public static int n;
    public static int[][] grid;
    public static ArrayList<Pair> loc = new ArrayList<>();
    public static ArrayList<Integer> put = new ArrayList<>();
    public static int maxArea;

    public static boolean[][] visited;


    public static int explode() {

        int count = 0;

        for (int i=0; i<loc.size(); i++) {
            
            int x = loc.get(i).getX();
            int y = loc.get(i).getY();

            visited[x][y] = true;

            if(put.get(i) == 0) {
                
                for (int k=1; k<=2; k++) {
                    int nx = x + k;

                    if (0<=nx && nx <n) {
                        visited[nx][y] = true;
                    }
                }
                

                for (int k=1; k<=2; k++) {
                    int nx = x - k;

                    if (0<=nx && nx <n) {
                        visited[nx][y] = true;
                    }
                }

            } else if (put.get(i) == 1) {
                if (0<= x+1 && x+1 <n) {
                    visited[x+1][y] = true;
                }
                
                if (0<= x-1 && x-1 <n ) {
                    visited[x-1][y] = true;
                }

                if (0<= y+1 && y+1 <n) {
                    visited[x][y+1] = true;
                }

                if (0<= y-1 && y-1 <n) {
                    visited[x][y-1] = true;
                }

            } else {
                if (0<= x+1 && x+1 <n && 0<= y+1 && y+1 <n) {
                    visited[x+1][y+1] = true;
                }
                if (0<= x-1 && x-1 <n && 0<= y-1 && y-1 <n) {
                    visited[x-1][y-1] = true;
                }
                if (0<= x+1 && x+1 <n && 0<= y-1 && y-1 <n) {
                    visited[x+1][y-1] = true;
                }
                if (0<= x-1 && x-1 <n && 0<= y+1 && y+1 <n) {
                    visited[x-1][y+1] = true;
                }
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void choose(int current) {


        if (current == loc.size()) {
            
            int explodeResult = explode();
            
            if (explodeResult > maxArea) {
                maxArea = explodeResult;
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    visited[i][j] = false;
                }
            }

            return;
        }

        for (int i=0; i<3; i++) {
            put.add(i);
            choose(current+1);
            put.remove(put.size()-1);
        }

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        maxArea = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 1){
                    loc.add(new Pair(i,j));
                }
            }
        }

        choose(0);

        System.out.println(maxArea);
    }
}