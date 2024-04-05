import java.util.*;

public class Main {

    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int min_value = Integer.MAX_VALUE;
    static int temp = 0;

    public static void choose(int current, int count) {

        if (count == n) {

            if(current == 0) {
                min_value = Math.min(min_value, temp);
            }
            return;
        }

        for(int i=0; i<n; i++) {
            
            if (graph[current][i]!=0 && visited[i]==false) {

                visited[i] = true;
                temp += graph[current][i];

                choose(i, count+1);

                visited[i] = false;
                temp -= graph[current][i];
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n];
        

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        choose(0,0);
        System.out.println(min_value);
    }
}