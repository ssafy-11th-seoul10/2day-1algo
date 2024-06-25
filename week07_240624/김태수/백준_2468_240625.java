import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = 1;

        for (int h = 1; h <= 100; h++) {
            boolean[][] visited = new boolean[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > h) {
                        bfs(h, visited, map, i, j);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }

        System.out.println(result);
    }

    private static void bfs(int h, boolean[][] visited, int[][] map, int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = now[0] + dy[i];
                int moveX = now[1] + dx[i];

                if (0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map.length){
                    if (!visited[moveY][moveX] && map[moveY][moveX] > h){
                        q.offer(new int[]{moveY, moveX});
                        visited[moveY][moveX] = true;
                    }
                }
            }
        }
    }
}
