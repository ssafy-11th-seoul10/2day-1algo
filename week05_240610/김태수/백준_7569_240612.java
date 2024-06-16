import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private static int n;
    private static int m;
    private static int h;
    private static int[][][] map;
    private static boolean[][][] visited;
    private static int tomatoCount = 0;
    private static Deque<int[]> q = new ArrayDeque<>();
    private static int[] dy = {0, 1, -1, 0, 0, 0};
    private static int[] dx = {1, 0, 0, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        map = new int[h][n][m]; // 높이, 세로, 가로
        visited = new boolean[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = sc.nextInt();
                    if (map[i][j][k] == 0) {
                        tomatoCount++;
                    } else if (map[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k, 0});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int days = 0;
        if (tomatoCount == 0) {
            return days;
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 6; i++) {
                int moveZ = now[0] + dz[i];
                int moveY = now[1] + dy[i];
                int moveX = now[2] + dx[i];

                if (inMap(moveZ, moveY, moveX) && map[moveZ][moveY][moveX] == 0 && !visited[moveZ][moveY][moveX]) {
                    q.offer(new int[]{moveZ, moveY, moveX, now[3] + 1});
                    visited[moveZ][moveY][moveX] = true;
                    map[moveZ][moveY][moveX] = 1; // 익은 토마토로 상태 업데이트
                    tomatoCount--;
                    days = now[3] + 1; // 날짜 업데이트
                }
            }
        }
        return tomatoCount == 0 ? days : -1;
    }

    private static boolean inMap(int z, int y, int x) {
        return 0 <= z && z < h && 0 <= y && y < n && 0 <= x && x < m;
    }
}
