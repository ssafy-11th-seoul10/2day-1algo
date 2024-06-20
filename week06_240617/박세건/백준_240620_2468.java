import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int N, M;

    private static int minHeight = 100, maxHeight = 1;
    private static int[][] map;

    private static int[] dix = {-1, 0, 1, 0};
    private static int[] diy = {0, 1, 0, -1};
    private static int answer = 1;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
        for (int i = maxHeight; i >= minHeight; i--) {
            int safeAreaCnt = findSafeArea(i);
//            System.out.println(i + " " + safeAreaCnt);
            answer = Math.max(answer, safeAreaCnt);
        }
        System.out.println(answer);
    }

    private static int findSafeArea(int height) {
        boolean[][] visited = new boolean[N][N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false && map[i][j] > height) {
                    cnt++;
                    visited[i][j] = true;
                    searchMap(i, j, height, visited);
                }
            }
        }
        return cnt;
    }

    private static void searchMap(int x, int y, int height, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int dx = x + dix[i];
            int dy = y + diy[i];
            if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
                continue;
            }

            if (map[dx][dy] <= height) {
                continue;
            }
            if (!visited[dx][dy]) {
                visited[dx][dy] = true;
                searchMap(dx, dy, height, visited);
            }


        }
    }
}
