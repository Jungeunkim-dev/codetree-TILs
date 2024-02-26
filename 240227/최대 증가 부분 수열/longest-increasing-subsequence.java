import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.fill(dp, 1);

        for(int i=2; i<=N; i++){

            for(int j=1; j<i; j++) {
                
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

        }

        int max_value = 0;

        for(int num : dp) {
            if(num > max_value) {
                max_value = num;
            }
        }

        System.out.println(max_value);
    }
}