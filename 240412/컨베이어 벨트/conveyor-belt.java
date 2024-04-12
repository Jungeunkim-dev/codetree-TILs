import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] upBelt = new int[n];
        int[] downBelt = new int[n];

        for(int i=0; i<n; i++) {
            upBelt[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            downBelt[n-i-1] = sc.nextInt();
        }

        for(int time=1; time<=t; time++) {
            int upTemp = upBelt[n-1];

            for(int i = n-1; i >= 1; i--) {
                upBelt[i] = upBelt[i-1];
            }

            upBelt[0] = downBelt[0];

            for(int i = 0; i < n-1; i++) {
                downBelt[i] = downBelt[i+1];
            }

            downBelt[n-1] = upTemp;
        }

        for(int i=0; i<n; i++)
            System.out.print(upBelt[i] + " ");
        System.out.println();
        for(int i=0; i<n; i++)
            System.out.print(downBelt[n-i-1] + " ");
    }
}