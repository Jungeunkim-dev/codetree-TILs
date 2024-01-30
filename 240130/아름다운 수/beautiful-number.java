import java.util.*;

public class Main {

    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int[] nums = {1, 2, 3, 4};
    public static int count; // 자릿수 개수 카운팅
    public static int n;

    public static int answer = 0;

    public static void choose(int current) {

        // 종료조건
        if (current > n) {
            return;
        } else if (current == n) {
            answer ++;
            return;
        }

        for (int i=0; i < 4; i++) {
            arr.add(nums[i]);
            choose(current + nums[i]);            
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        choose(1);
        System.out.println(answer);
    }
}