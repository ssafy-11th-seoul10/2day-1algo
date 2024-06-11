import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, map[][], dist[][];
    private static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    private static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    private static final int INF = 987654321;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], INF);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    pq.add(new int[]{i, j, 0});
                    dist[i][j] = 0;
                }
            }
        }

        bfs();
//        debugPrint();
        print();
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] != INF) sb.append(dist[i][j]).append(" ");
                else {
                    if (map[i][j] == 0) sb.append("0 ");
                    else sb.append("-1 ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs() {
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int r = temp[0];
            int c = temp[1];
            int d = temp[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] == 0) continue;

                if (dist[nr][nc] > d + 1) {
                    dist[nr][nc] = d + 1;
                    pq.add(new int[]{nr, nc, d + 1});
                }
            }
        }
    }

    private static void debugPrint() {
        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(dist[i]));
    }
}
