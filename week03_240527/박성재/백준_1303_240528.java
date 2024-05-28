import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_1303_240528 {
    static int n;
    static int m;
    static char[][] board;
    static boolean[][] visited;

    static int[] ry = { 0, 0, 1, -1 };
    static int[] rx = { 1, -1, 0, 0 };

    static int countW = 0;
    static int countB = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, board[i][j]);
                }
            }
        }

        sb.append(countW).append(" ").append(countB).append("\n");
        System.out.println(sb);
    }

    static void bfs(int y, int x, char team) {
        int count = 0;

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        visited[y][x] = true;

        deque.addLast(new int[] { y, x });

        while (!deque.isEmpty()) {
            int[] now = deque.pollFirst();
            count++;

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if (r < 0 || c < 0 || r >= m || c >= n)
                    continue;

                if (board[r][c] != team)
                    continue;

                if (!visited[r][c]) {
                    visited[r][c] = true;
                    deque.addLast(new int[] { r, c });
                }
            }

        }

        if (team == 'W') {
            countW += Math.pow(count, 2);
        } else {
            countB += Math.pow(count, 2);
        }
    }
}
