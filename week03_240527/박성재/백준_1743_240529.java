import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_1743_240529 {

    static int n;
    static int m;
    static int[][] board;
    static boolean[][] visited;

    static int[] ry = { 0, 0, 1, -1 };
    static int[] rx = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        int k = Integer.parseInt(st.nextToken());

        board = new int[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            board[y][x] = 1;
        }

        visited = new boolean[n + 1][m + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static int bfs(int y, int x) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[] { y, x });
        visited[y][x] = true;
        int count = 0;

        while (!deque.isEmpty()) {
            int[] now = deque.pollFirst();
            count++;
            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if (r < 1 || c < 1 || r > n || c > m)
                    continue;

                if (board[r][c] != 1)
                    continue;

                if (!visited[r][c]) {
                    visited[r][c] = true;
                    deque.addLast(new int[] { r, c });
                }
            }
        }

        return count;

    }
}
