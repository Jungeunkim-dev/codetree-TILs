import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair b) {
        // 기준 2가지 (위에서부터, 왼쪽에서부터 오름차순으로)
        if(x!=b.x) return x-b.x;
        else return y-b.y;
    }
}

public class Main {

    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 11; // 문제에서 정의된 값(가능한 최대 가로줄의 개수)

    public static int n,m;

    public static ArrayList<Pair> lines = new ArrayList<>();
    public static ArrayList<Pair> selectedLines = new ArrayList<>();
    
    public static int ans = INT_MAX;


    // 위에서부터 swap 해서 사다리 결과를 얻어낼 수 있다.
    public static boolean check_possible() {
        int[] original = new int[MAX_N]; // 0... 배열로 초기화
        int[] selected = new int[MAX_N];

        for(int i=0; i<n; i++){
            original[i] = selected[i] = i; // 최초 순서 정해주기
        }

        for(int i=0; i<lines.size(); i++) {
            int idx = lines.get(i).y; // 가로줄
            int temp = original[idx];

            original[idx] = original[idx+1];
            original[idx+1] = temp;
        }

        for(int i=0; i<selectedLines.size(); i++) {
            int idx = selectedLines.get(i).y; // 가로줄
            int temp = selected[idx];

            selected[idx] = selected[idx+1];
            selected[idx+1] = temp;
        }

        for(int i=0; i<n; i++) {
            if(original[i] != selected[i]) {
                return false;
            }
        }


        return true;
    }

    public static void findCases(int cnt) {
        if(cnt == m) {
            if(check_possible()){
                ans = Math.min(ans, selectedLines.size());
            }
            return;
        }

        selectedLines.add(lines.get(cnt));

        findCases(cnt+1);

        selectedLines.remove(selectedLines.size() - 1);

        findCases(cnt+1);
    }
    

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        

        for(int i=0; i<m; i++) {
            int col = sc.nextInt();
            int row = sc.nextInt();

            lines.add(new Pair(row, col-1)); // index 고려해서 -1
        }

        Collections.sort(lines);

        findCases(0);

        System.out.println(ans);
    }
}