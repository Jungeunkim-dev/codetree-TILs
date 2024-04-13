import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] zenga = new int[n];
        int[][] removeBlock = new int[2][2];

        int endOfArray = n;

        for(int i=0; i<n; i++) {
            zenga[i] = sc.nextInt();
        }


        for(int k=0; k<2; k++) {
            int s = sc.nextInt()-1;
            int e = sc.nextInt()-1;

            for(int i=s; i<=e; i++) {
                zenga[i] = 0;
            }

            int[] temp = new int[n];
            int endOfTempArray = 0;

            for(int i=0; i<endOfArray; i++) {

                if (zenga[i]!=0) {
                    temp[endOfTempArray] = zenga[i];
                    endOfTempArray++;
                }
            }

            for(int i=0; i<endOfTempArray; i++) {
                zenga[i] = temp[i];
            }
            
            endOfArray = endOfTempArray;
        }

        System.out.println(endOfArray);
        for(int i=0; i<endOfArray; i++){
            System.out.println(zenga[i]);
        }
   }
}