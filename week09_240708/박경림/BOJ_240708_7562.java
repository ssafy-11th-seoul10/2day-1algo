import java.io.*;
import java.util.*;

public class Main {
    private static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            Queue<int[]> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            q.add(new int[] {r1, c1, 0});
            boolean[][] visited = new boolean[l][l];
            visited[r1][c1] = true;
            int result = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                int[] temp = q.poll();
                if (temp[0] == r2 && temp[1] == c2) {
                    result = Math.min(result, temp[2]);
                    continue;
                }

                for (int i = 0; i < 8; i++) {
                    int nr = temp[0] + dr[i];
                    int nc = temp[1] + dc[i];
                    if (nr < 0 || nr >= l || nc < 0 || nc >= l || visited[nr][nc]) continue;
                    q.add(new int[] {nr, nc, temp[2] + 1});
                    visited[nr][nc] = true;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
