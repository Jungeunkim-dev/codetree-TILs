import java.util.*;

public class Main {

    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int n;
    public static int k;

    public static void print() {
        for(int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i)+" ");
        }

        System.out.println();
    }


    // current = 현재 자리위치
    public static void choose(int current) {

        if (current == n) {
            print();
            return;
        }

        for (int i=1; i<=k; i++) {
            arr.add(i);
            choose(current+1);
            arr.remove(arr.size() - 1);

        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        choose(0);
    }
}