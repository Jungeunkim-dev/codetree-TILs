import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            String s = sc.next();

            if (map.containsKey(s)){
                int count = map.get(s);
                map.put(s, count+1);
            } else {
                map.put(s, 1);
            }
        }

        List<Integer> values = 
        map.values()
        .stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

        if(values.isEmpty()){
            System.out.println(0);
        } else {
            System.out.println(values.get(0));
        }
    }
}