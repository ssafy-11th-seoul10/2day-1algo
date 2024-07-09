import java.io.*;
import java.util.*;

public class Main {
    private static int[] dl = {0, 0, 0, 0, -1, 1};
    private static int[] dr = {-1, 1, 0, 0, 0, 0};
    private static int[] dc = {0, 0, -1, 1, 0, 0};
    private static int l, r, c, sl, sr, sc, el, er, ec, result;
    private static char[][][] map;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;

            map = new char[l][r][c];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    map[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < c; k++) {
                        if (map[i][j][k] == 'S') {
                            sl = i;
                            sr = j;
                            sc = k;
                        } else if (map[i][j][k] == 'E') {
                            el = i;
                            er = j;
                            ec = k;
                        }
                    }
                }
                br.readLine();
            }
            result = Integer.MAX_VALUE;
            bfs();
        }

        System.out.print(sb);
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[l][r][c];
        q.add(new int[] {sl, sr, sc, 0});
        visited[sl][sr][sc] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 6; i++) {
                int nl = temp[0] + dl[i];
                int nr = temp[1] + dr[i];
                int nc = temp[2] + dc[i];

                if (nl < 0 || nl >= l || nr < 0 || nr >= r || nc < 0 || nc >= c)
                    continue;
                if (map[nl][nr][nc] == '#' || visited[nl][nr][nc])
                    continue;
                if (nl == el && nr == er && nc == ec) {
                    result = Math.min(result, temp[3] + 1);
                    continue;
                }
                q.add(new int[] {nl, nr, nc, temp[3] + 1});
                visited[nl][nr][nc] = true;
            }
        }

        if (result == Integer.MAX_VALUE) {
            sb.append("Trapped!").append("\n");
        } else {
            sb.append("Escaped in ").append(result).append(" minute(s).").append("\n");
        }
    }
}
