import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i=0;i<n; i++){
            int num = sc.nextInt();

            if(map.containsKey(num)){
                int count = map.get(num);
                map.put(num, count+1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer> keys = 
        map.keySet()
        .stream()
        .distinct()
        .collect(Collectors.toList());

        int resultCount = 0;

        for(Integer key : keys) {
            if(map.containsKey(k-key)) {

                if(k-key == key) {
                    int c1 = map.get(key);

                    resultCount += (c1+c1-1) / 2;
                } else {

                int c1 = map.get(k-key);
                int c2 = map.get(key);

                resultCount += (c1 * c2);

                map.remove(key);
                }
            }
        }

        System.out.println(resultCount);
    }
}