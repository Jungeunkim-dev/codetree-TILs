import java.util.*;


public class Main {

    public static int N;
    public static int M;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void printArr() {
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void choose(int current, int k){

        if (current == M){
            printArr();
            return;
        }

        for(int i=k+1; i<=N; i++) {
            arr.add(i);
            choose(current+1, i);
            arr.remove(arr.size()-1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        choose(0, 0);
    }
}