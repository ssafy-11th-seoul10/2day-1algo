import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, count, size;
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                    size = Math.max(size, 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n").append(size);
        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        count++;
        int ns = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c, ns++});
        map[r][c] = 0;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 1) {
                    q.add(new int[] {nr, nc, ns});
                    map[nr][nc] = 0;
                    size = Math.max(size, ns);
                    ns++;
                }
            }
        }

//        print();
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println(count + " " + size);
        System.out.println("------------------------");
    }
}
