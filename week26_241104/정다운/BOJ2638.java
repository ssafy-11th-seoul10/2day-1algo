import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2638 {

    static int N, M;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }

    public static int checkCheese(int x, int y) {
        int temp = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny) && visited[nx][ny] && board[nx][ny] == 0)
                temp++;
        }
        return temp;
    }

    public static void bfs(int sx, int sy) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sx, sy});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0]; int y = pos[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i]; int ny = y + dy[i];
                if(inRange(nx, ny) && !visited[nx][ny]) {
                    if(board[nx][ny] == 1)
                        continue;
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void printVisited() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(visited[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        int empty_x = 0; int empty_y = 0;
        Queue<int[]> cheese = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int pos = Integer.parseInt(st.nextToken());

                board[i][j] = pos;
                if(pos == 1)
                    cheese.add(new int[] {i, j, 0});

                if(empty_x == 0 && empty_y == 0 && pos == 0) {
                    empty_x = i; empty_y = j;
                }
            }
        }

        // Simulation - cheese melting
        bfs(0, 0);
        int cnt = 0;
        List<int[]> toMelt = new ArrayList<>();

        while (!cheese.isEmpty()) {

            int[] chee = cheese.poll();
            int cx = chee[0]; int cy = chee[1];
            int time = chee[2];

            if(time > cnt) {
                for(int[] pos : toMelt)
                    board[pos[0]][pos[1]] = 0;
                cnt = time;
                toMelt = new ArrayList<>();
                visited = new boolean[N][M];
                bfs(empty_x, empty_y);
                //print();
            }

            if(checkCheese(cx, cy) >= 2)
                toMelt.add(new int[] {cx, cy});
            else
                cheese.add(new int[] {cx, cy, time+1});
        }

        if(!toMelt.isEmpty()) // 마지막 치즈들
            cnt++;

        System.out.println(cnt);
    }
}
