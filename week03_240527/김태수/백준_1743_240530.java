import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {

    private static int r;
    private static int c;
    private static String[][] map;
    private static boolean[][] visited;
    private static int count;
    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        int n = sc.nextInt();

        map = new String[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = ".";
            }
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            map[a][b] = "#";
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j].equals("#")) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
    }

    private static void bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});

        int nowCount = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];

            for (int i = 0; i < 4; i++) {
                int moveY = nowY + dy[i];
                int moveX = nowX + dx[i];

                if (0 <= moveY && moveY < r && 0 <= moveX && moveX < c) {
                    if (!visited[moveY][moveX] && map[moveY][moveX].equals("#")) {
                        q.offer(new int[]{moveY, moveX});
                        visited[moveY][moveX] = true;
                        nowCount++;
                    }
                }
            }
        }

        count = Math.max(count, nowCount);
    }
}
