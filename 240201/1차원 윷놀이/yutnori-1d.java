import java.util.*;

public class Main {
    
    public static int n;
    public static int m;
    public static int k;
    public static int[] nums;
    public static int[] loc;
    
    public static int max_score = 0;
    

    public static void countReachedM() {
        int count = 0;
        for(int i=0; i<k; i++) {
            if (loc[i] >= m){
                count++;
            }
        }

        if (count > max_score) {
            max_score = count;
        }
    }

    public static void choose(int current) {


        if (current == n) {
            countReachedM();            
            return;
        }

        for(int i=0; i<k; i++) {


            if (loc[i] >= m){
                continue;
            }

            loc[i] += nums[current];
            choose(current+1);
            loc[i] -= nums[current];
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        nums = new int[n];
        loc = new int[n];

        for(int i = 0; i<n; i++) {
            nums[i] = sc.nextInt();
        }

        choose(0);

        System.out.println(max_score);
    }
}