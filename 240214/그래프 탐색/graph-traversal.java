import java.util.*;

public class Main {


    static final int MAX_VERTICES = 1000;
    static int n,m;
    static int count = 0;

    public static ArrayList<Integer>[] graph = new ArrayList[MAX_VERTICES+1];
    public static boolean[] visited = new boolean[MAX_VERTICES+1];

    public static void DFS(int v) {
        for(int i=0; i<graph[v].size(); i++) {
            int cur = graph[v].get(i);

            if (!visited[cur]) {
                count++;
                visited[cur] = true;
                DFS(cur);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>(); // 초기화 시켜주기
        }

        for(int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x); 
        }

        
        DFS(1);
        System.out.println(count == 0 ? 0 : count-1);
    }
}