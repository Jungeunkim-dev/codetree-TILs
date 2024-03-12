import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n];

        for(int i=0; i<n; i++){
            int c = sc.nextInt();

            if(map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, count+1);
            } else {
                map.put(c, 1);
            }
        }

        for(int i=0; i<m; i++){
            int q = sc.nextInt();

            System.out.print(map.getOrDefault(q, 0) + " ");
        }
    }
}