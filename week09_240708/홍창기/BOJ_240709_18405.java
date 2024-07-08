import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_240709_18405 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        ArrayDeque<Point>[] bfsQue = new ArrayDeque[k + 1];

        for (int u = 1; u <= k; u++) {
            bfsQue[u] = new ArrayDeque<Point>();
        }

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int y = 0; y < n; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());

                if (board[x][y] != 0) {
                    bfsQue[board[x][y]].offer(new Point(x, y));
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= s; t++) {
            for (int u = 1; u <= k; u++) {
                int iter = bfsQue[u].size();

                while (iter-- > 0) {
                    Point curPos = bfsQue[u].poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = curPos.x + dx[d];
                        int ny = curPos.y + dy[d];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                            board[nx][ny] = board[curPos.x][curPos.y];
                            bfsQue[board[nx][ny]].offer(new Point(nx, ny));
                        }
                    }
                }
            }
        }

        System.out.println(board[x - 1][y - 1]);
        br.readLine();
    }

}
