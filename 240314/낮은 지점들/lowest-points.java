import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Long, Long> map = new HashMap<>();

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();

            if (map.containsKey(x)) {
                if(map.get(x) > y) {
                    map.put(x, y);
                }
            } else {
                map.put(x,y);
            }
        }

        int ans = 0;

        List<Long> values = map.values().stream().collect(Collectors.toList());

        for(Long i : values){
            ans+= i;
        }

        System.out.println(ans);

    }
}