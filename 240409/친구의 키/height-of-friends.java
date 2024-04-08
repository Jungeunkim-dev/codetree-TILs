import java.util.*;

public class Main {

    static int n;
    static int m;
    static List<Integer>[] arr;
    static int[] indegree;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new ArrayList[n+1];
        indegree = new int[n+1];

        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a].add(b);
            indegree[b]++; // 진입 차수 증가
        }

        for(int i=1; i<=n; i++) {
            if (indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int val = q.poll();

            answer.add(val);

            for(int i=0; i<arr[val].size(); i++) {
                int item = arr[val].get(i);

                indegree[item]--;

                if(indegree[item] == 0) {
                    q.add(item);
                }
            }
        }

        for(int item : answer) {
            System.out.print(item+" ");
        }
    }
}