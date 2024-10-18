import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N, M;
    private static int map[][];
    private static int distance[][];
    private static int sx, sy;

    private static int[] dix = {-1, 0, 1, 0};
    private static int[] diy = {0, 1, 0, -1};


    private static int bfsCnt = 0;

    public static void main(String[] args) throws IOException {
        inputSetting();
        bfs();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(distance[i][j] == Integer.MAX_VALUE ? -1 + " " : distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy, 0});
        distance[sx][sy] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = cur[0] + dix[i];
                int dy = cur[1] + diy[i];
                int cnt = cur[2];
                if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
                    continue;
                }
                if (map[dx][dy] == 0) {
                    continue;
                }
                if (distance[dx][dy] <= cnt + 1) {
                    continue;
                }
                distance[dx][dy] = cnt + 1;
                queue.add(new int[]{dx, dy, cnt + 1});
            }
        }

    }

    private static void inputSetting() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                distance[i][j] = (map[i][j] == 0) ? 0 : Integer.MAX_VALUE;
            }
        }
    }
}
