import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, h, result;
    private static int box[][][];
    private static int[][] dir = {{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};
    private static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        box = new int[h][n][m];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                    if (box[k][i][j] == 1)
                        q.add(new int[] {k, i, j, 0});
                }
            }
        }
        bfs();
        checkZero();
        System.out.println(result);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int[] d : dir) {
                int nh = temp[0] + d[0];
                int nn = temp[1] + d[1];
                int nm = temp[2] + d[2];

                if (nh >= 0 && nh < h && nn >= 0 && nn < n && nm >= 0 && nm < m && box[nh][nn][nm] == 0) {
                    box[nh][nn][nm] = 1;
                    q.add(new int[] {nh, nn, nm, temp[3] + 1});
                    result = Math.max(result, temp[3] + 1);
                }
            }
        }
    }

    private static void checkZero() {
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j ++) {
                    if (box[k][i][j] == 0) {
                        result = -1;
                        return;
                    }
                }
            }
        }
    }
}
