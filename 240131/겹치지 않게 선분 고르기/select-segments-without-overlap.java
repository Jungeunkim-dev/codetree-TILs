import java.util.*;

public class Main {

    public static ArrayList<Pair> arr = new ArrayList<>();
    public static int[][] lines;
    public static int n;
    public static int max_count = 0;


    public static class Pair{
        public int start;
        public int end;

        public Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        public void printAll() {
            for(int i=0; i<arr.size(); i++){
                System.out.println(this.start+","+this.end);
            }
        }
    }


    public static void choose(int current) {


        if (current == n-1){
            System.out.println(arr.size());
            Pair pair = new Pair(1,2);
            pair.printAll();
            max_count = Math.max(max_count, arr.size());
            return;
        }

        for (int i = current; i<n; i++) {
            
            if(arr.size() == 0) {
                arr.add(new Pair(lines[i][0], lines[i][1]));
                choose(i + 1);
                arr.remove(arr.size() - 1);                
            } 
            
            else {
                if(lines[i][0] > arr.get(arr.size() -1).end) {
                    arr.add(new Pair(lines[i][0], lines[i][1]));
                    choose(i + 1);
                    arr.remove(arr.size() - 1);
                }
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        lines = new int[n][2];

        for(int i=0;i<n;i++) {
            lines[i][0] = sc.nextInt();
            lines[i][1] = sc.nextInt();
        }


        Arrays.sort(lines, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];
        });

        choose(0);

        // System.out.println(max_count);
    }
}