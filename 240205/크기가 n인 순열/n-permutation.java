import java.util.*;

public class Main {

    public static int n;
    public static List<Integer> arr = new ArrayList<>();
    public static boolean[] visited;

    public static void printArr() {

        for(int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i)+" ");
        }

        System.out.println();
    }

    public static void choose(int current) {
        
        if (current == n) {
            printArr();
            return;
        }

        for (int i=1; i<=n; i++) {

            if (visited[i]) {
                continue;
            } 

            visited[i] = true;
            arr.add(i);

            choose(current+1);

            visited[i] = false;
            arr.remove(arr.size()-1);


        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n+1];
        Arrays.fill(visited, false);

        choose(0);
    }
}