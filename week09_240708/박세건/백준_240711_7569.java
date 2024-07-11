import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M, H;

    private static int[] dix = {-1, 0, 1, 0};
    private static int[] diy = {0, 1, 0, -1};
    private static int[][][] map;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();
        map = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }
        System.out.println(bfs(queue));
    }

    private static int bfs(Queue<int[]> queue) {
        int nowDay = -1;
        while (queue.size() > 0) {
            int[] cur = queue.poll();
//            System.out.println(Arrays.toString(cur));
            int x = cur[1];
            int y = cur[2];
            int z = cur[0];
            int cnt = cur[3];
            if (cnt != nowDay) {
                if (isAllChecked()) {
                    return cnt;
                }
                nowDay = cnt;
            }
            for (int i = 0; i < 4; i++) {
                int dx = x + dix[i];
                int dy = y + diy[i];
                if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
                    continue;
                }
                if (map[z][dx][dy] == 0) {
                    map[z][dx][dy] = 1;
                    queue.add(new int[]{z, dx, dy, cnt + 1});
                }
            }
            /*
             *   z 축 확인
             * */
            if (z - 1 >= 0 && map[z - 1][x][y] == 0) {
                map[z - 1][x][y] = 1;
                queue.add(new int[]{z - 1, x, y, cnt + 1});
            }
            if (z + 1 < H && map[z + 1][x][y] == 0) {
                map[z + 1][x][y] = 1;
                queue.add(new int[]{z + 1, x, y, cnt + 1});
            }
        }
        return -1;
    }

    private static boolean isAllChecked() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
