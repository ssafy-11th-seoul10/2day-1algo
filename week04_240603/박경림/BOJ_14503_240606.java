import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, result;
    private static int[][] dir = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(result);
    }

    private static void clean(int r, int c, int d) {
        if (map[r][c] == 0) {
            map[r][c] = 2;
            result++;
        }

        for (int i = 0; i < 4; i++) {
            int nd = (d + 3 - i) % 4;
            int nr = r + dir[nd][0];
            int nc=  c + dir[nd][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0) {
                clean(nr, nc, nd);
                return;
            }
        }

        int bd = (d + 2) % 4;
        int nr = r + dir[bd][0];
        int nc = c + dir[bd][1];
        if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != 1)
            clean(nr, nc, d);
    }
}
