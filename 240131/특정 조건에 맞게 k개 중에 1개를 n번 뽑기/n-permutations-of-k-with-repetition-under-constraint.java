import java.util.*;

public class Main {
    
    public static int K;
    public static int N;

    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int answer_count;

    public static void printArr() {

        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }

        System.out.println();
    }

    public static void choose(int current) {
        
        // if size of arr == N ; return
        if (current == N) {
            printArr();
            return;
        }


        for (int i=0; i < K; i++) {

            if (i>=3) {
                if (arr.get(current) == i && arr.get(current-1) == i) {
                    continue;
                }
            }

            arr.add(i+1);
            choose(current+1);
            arr.remove(arr.size() - 1);
        }
    }
    
    
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        N = sc.nextInt();

        choose(0);
    }
}