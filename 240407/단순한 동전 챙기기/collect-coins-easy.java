import java.util.*;

public class Main {

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static char[][] grid;
    static int n;
    static int m  = 3;
    static int[][] delta = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    
    static int min_move = Integer.MAX_VALUE;

    static ArrayList<Pair> coin = new ArrayList<>();
    static ArrayList<Pair> selected = new ArrayList<>();
    
    static Pair start;
    static Pair end;

    public static int dist(Pair a, Pair b) {
        // 이동 시 별도의 제한조건이 없으니 x값, y값 사이의 절댓값 차의 합으로 구함.
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y); 
    }


    public static int calculate() {

        int move = dist(start, selected.get(0)); 

        for(int i=0; i<m-1; i++) {
            move += dist(selected.get(i), selected.get(i+1));
        }

        move += dist(selected.get(m-1), end);

        return move;
    }

    public static void findMinMove(int curr, int cnt) {

        if (cnt == m) {
            min_move = Math.min(min_move, calculate());
            return;
        }

        // 코인의 개수를 다 세었을 때는 리턴.
        if (curr == (int) coin.size()){
            return;
        }

        // 이번 인덱스의 coin을 선택하지 않는 경우
        findMinMove(curr+1, cnt);

        // 이번 인덱스의 coin을 선택하는 경우
        selected.add(coin.get(curr));
        findMinMove(curr+1, cnt+1);
        selected.remove(selected.size()-1);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        grid = new char[n][n];

        for(int i=0; i<n; i++) {
            String input = sc.next();
            for(int j=0; j<n; j++) {
                grid[i][j] = input.charAt(j);

                if (grid[i][j] == 'S') start = new Pair(i, j);
                if (grid[i][j] == 'E') end = new Pair(i, j);
            }
        }


        // 1부터 증가하는 순으로 coin의 위치에 저장해 놓는다.
        for(int num = 1; num <= 9; num++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {

                    if (grid[i][j] - '0' == num) {
                        coin.add(new Pair(i, j));
                    }
                }
            }
        }

        findMinMove(0, 0);

        if (min_move == Integer.MAX_VALUE) min_move = -1;

        System.out.println(min_move);
    }
}