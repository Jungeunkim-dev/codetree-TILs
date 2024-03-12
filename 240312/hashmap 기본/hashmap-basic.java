import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> m = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            String order = sc.next();
            int K = sc.nextInt();

            if(order.equals("add")){
                int V = sc.nextInt();
                m.put(K,V);
            } else if(order.equals("remove")){
                m.remove(K);
            } else {
                if(m.containsKey(K)){
                    System.out.println(m.get(K));
                } else {
                    System.out.println("None");
                }
            }
        }

    }
}