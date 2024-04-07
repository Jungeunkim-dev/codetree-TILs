import java.util.*;

public class Main {

    static int n;
    static int minSum = Integer.MAX_VALUE;
    static int tempSum = 0;
    static int totalSum = 0;
    static int[] nums;

    // 원소합의 차를 계산
    public static int cal() {
        int group2 = totalSum - tempSum;
        return Math.abs(tempSum - group2);
    }
    
    public static void choose(int currIdx, int count) {
        if (count == n) {
            
            minSum = Math.min(minSum, cal());
            return;
        }

        if (currIdx ==  2 * n - 1) {
            return;
        }

        choose(currIdx+1, count);

        tempSum += nums[currIdx];
        choose(currIdx+1, count+1);
        tempSum -= nums[currIdx];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n*2];

        for(int i=0; i<2*n; i++) {
            nums[i] = sc.nextInt();
            totalSum += nums[i];
        }

        choose(0, 0);

        System.out.println(minSum);
    }
}