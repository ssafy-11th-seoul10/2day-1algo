import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Obstacle_recognition_program {

    static int N;

    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }

    public static int bfs(int x, int y) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int cnt = 1;

        while(!queue.isEmpty()) {

            int[] curPos = queue.poll();
            int curX = curPos[0]; int curY = curPos[1];

            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(inRange(nx, ny) && !visited[nx][ny] && board[nx][ny] == 1) {

                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String tmp = br.readLine();

            for(int j = 0; j < N; j++)
                board[i][j] = tmp.charAt(j) - '0';
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && board[i][j] != 0) {
                    int count = bfs(i, j);
                    list.add(count);
                }
            }

        System.out.println(list.size());
        Collections.sort(list);
        for(int size : list)
            System.out.println(size);
    }
}
