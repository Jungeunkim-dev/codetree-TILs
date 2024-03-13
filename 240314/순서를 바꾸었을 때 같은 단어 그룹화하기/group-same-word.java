import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        int n = sc.nextInt();

        for (int i = 0; i<n; i++ ){
            String s = sc.next();

            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String sorted = new String(arr);

            if (map.containsKey(sorted)){
                int c= map.get(sorted);
                map.put(sorted, c+1);
            } else {
                map.put(sorted,1);
            }
        }

        List<Integer> values = map.values()
        .stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

        System.out.println(values.get(0));
    }
}