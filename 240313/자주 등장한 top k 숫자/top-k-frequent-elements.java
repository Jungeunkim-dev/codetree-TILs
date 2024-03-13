import java.util.*;
import java.util.stream.*;

public class Main {

    static class Pair implements Comparable<Pair> {
        int key;
        int value;

        public Pair(int k, int v){
            this.key = k;
            this.value = v;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.value != p.value) {
                return p.value - this.value;
            } else {
                return p.key - this.key;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> m = new HashMap<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i=0; i<n; i++) {
            
            int num = sc.nextInt();

            if (m.containsKey(num)){
                int count = m.get(num);
                m.put(num, count+1);
            } else {
                m.put(num, 1);
            }
        }


        List<Pair> arr = new ArrayList<>();

        for(Integer key : m.keySet()) {
            arr.add(new Pair(key, m.get(key)));
        }

        Collections.sort(arr);

        for(int i=0; i<k; i++) {
            System.out.print(arr.get(i).key + " ");
        }
    }
}