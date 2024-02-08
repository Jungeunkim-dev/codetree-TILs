import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];

        for(int i=0; i<10; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0; 
        int flag = 0;

        for(int i=0; i<10; i++){
            flag = i;
            if(arr[i] >= 250) {
                break;
            } else {
                sum += arr[i];
            }
        }

        System.out.print(sum+ " ");
        System.out.printf("%.1f%n", (double) sum / flag);
    }
}