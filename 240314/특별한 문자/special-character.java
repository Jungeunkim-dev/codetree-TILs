import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();

        String s = sc.next();

        char[] arr = s.toCharArray();

        for(char v:arr) {
            if(map.containsKey(v)) {
                int c = map.get(v);
                map.put(v, c+1);
            } else {
                map.put(v, 1);
            }
        }

        boolean flag = false;

        for(char v:arr) {
            if (map.get(v) == 1) {
                System.out.println(v);
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("None");
        }
    }
}