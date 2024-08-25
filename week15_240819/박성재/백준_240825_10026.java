import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_240825_10026 {
    static int n;
    static int[][] map;
    static int[][] handicapMap;
    static boolean[][] visited;
    static ArrayDeque<int[]> deque;
    static int[] ry = { 0, 0, 1, -1 };
    static int[] rx = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        handicapMap = new int[n][n];
        deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'G') {
                    map[i][j] = 1;
                } else if (s.charAt(j) == 'B') {
                    map[i][j] = 2;
                    handicapMap[i][j] = 2;
                }
            }
        }

        int answer = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map);
                    answer++;
                }
            }
        }
        sb.append(answer).append(" ");

        answer = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, handicapMap);
                    answer++;
                }
            }
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void bfs(int startY, int startX, int[][] map) {
        visited[startY][startX] = true;
        deque.addLast(new int[] { startY, startX });

        int num = map[startY][startX];
        while (!deque.isEmpty()) {
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if (r < 0 || c < 0 || r >= n || c >= n)
                    continue;

                if (map[r][c] != num)
                    continue;

                if (visited[r][c])
                    continue;

                visited[r][c] = true;
                deque.addLast(new int[] { r, c });
            }
        }
    }
}
