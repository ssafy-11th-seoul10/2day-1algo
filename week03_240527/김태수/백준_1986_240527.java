import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {

    private static int[] moveQY = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static int[] moveQX = {-1, 0, 1, 1, 1, 0, -1, -1};

    private static int[] moveNY = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] moveNX = {1, 2, 2, 1, -1, -2, -2, -1};

    private static String[][] map;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new String[n][m];

        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        int queenCount = sc.nextInt();
        for (int i = 0; i < queenCount; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            map[x][y] = "Q";
            deque.add(new int[]{x, y});
            visited[x][y] = true;
        }

        int knightCount = sc.nextInt();
        for (int i = 0; i < knightCount; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            map[x][y] = "K";
            deque.add(new int[]{x, y});
            visited[x][y] = true;
        }

        int pawnCount = sc.nextInt();
        for (int i = 0; i < pawnCount; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            map[x][y] = "P";
            visited[x][y] = true;
        }

        while (!deque.isEmpty()) {
            int[] now = deque.poll();
            int x = now[0];
            int y = now[1];
            String target = map[x][y];

            if (target.equals("Q")) {
                for (int i = 0; i < 8; i++) {
                    int nextX = x + moveQX[i];
                    int nextY = y + moveQY[i];

                    while (isCorrect(nextX, nextY) && map[nextX][nextY] == null) {
                        visited[nextX][nextY] = true;
                        nextX += moveQX[i];
                        nextY += moveQY[i];
                    }

                    if (isCorrect(nextX, nextY) && map[nextX][nextY] != null) {
                        visited[nextX][nextY] = true;
                    }
                }
            } else if (target.equals("K")) {
                for (int i = 0; i < 8; i++) {
                    int nextX = x + moveNY[i];
                    int nextY = y + moveNX[i];

                    if (isCorrect(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == null) {
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static boolean isCorrect(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
