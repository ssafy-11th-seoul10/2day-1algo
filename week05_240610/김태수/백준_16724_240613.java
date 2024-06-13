import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private static int n;
    private static int m;
    private static char[][] map;
    private static int[][] visited;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int count = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    moveTarget(i, j, count);
                    count++;
                }
            }
        }

        System.out.println(result);
    }

    private static void moveTarget(int y, int x, int num) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});
        visited[y][x] = num;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            char move = map[now[0]][now[1]];

            if (move == 'U') {
                now[0]--;
            } else if (move == 'D') {
                now[0]++;
            } else if (move == 'L') {
                now[1]--;
            } else {
                now[1]++;
            }

            if (visited[now[0]][now[1]] == 0) {
                q.offer(new int[]{now[0], now[1]});
                visited[now[0]][now[1]] = num;
            } else if (visited[now[0]][now[1]] == num) {
                visited[now[0]][now[1]] = num;
                result++;
                break;
            }
        }
    }
}
