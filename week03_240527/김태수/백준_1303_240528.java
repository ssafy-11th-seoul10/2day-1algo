import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};
    private static char[][] map;
    private static int n;
    private static int m;
    private static boolean[][] visited;
    private static int wCount;
    private static int BCount;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[m][n];

        for (int i = 0; i < m; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(wCount + " " + BCount);
    }

    private static void bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;

        char target = map[y][x];
        int count = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = now[0] + dy[i];
                int moveX = now[1] + dx[i];

                if (0 <= moveX && moveX < n && 0 <= moveY && moveY < m
                    && (map[moveY][moveX] == target && !visited[moveY][moveX])) {
                    visited[moveY][moveX] = true;
                    count++;
                    q.offer(new int[]{moveY, moveX});

                }
            }
        }

        if (target == 'W') {
            wCount += Math.pow(count, 2);
        } else {
            BCount += Math.pow(count, 2);
        }
    }
}
