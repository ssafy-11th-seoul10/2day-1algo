package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1926_241014 {

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(Pair start) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(start);
        map[start.x][start.y] = -1;
        int size = 1;
        while (!q.isEmpty()) {
            Pair now = q.remove();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]!=1) continue;
                map[nx][ny] = -1;
                size++;
                q.add(new Pair(nx, ny));
            }
        }
        maxValue = Math.max(maxValue, size);
    }


    static int n, m, maxValue;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        maxValue = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==1){
                    count++;
                    bfs(new Pair(i, j));
                }
            }
        }
        StringBuilder sb = new StringBuilder().append(count).append("\n").append(maxValue);
        System.out.println(sb);
    }
}
