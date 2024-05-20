import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_24463_240521 {

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
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];

        for (int x = 0; x < n; x++) {
            String line = br.readLine();

            for (int y = 0; y < m; y++) {
                board[x][y] = line.charAt(y);
            }
        }

        int i = 0;
        Point[] holes = new Point[2];

        for (int y = 0; y < m; y++) {
            if (board[0][y] == '.') {
                holes[i] = new Point(0, y);
                i++;
            }

            if (board[n - 1][y] == '.') {
                holes[i] = new Point(n - 1, y);
                i++;
            }
        }

        for (int x = 1; x < n - 1; x++) {
            if (board[x][0] == '.') {
                holes[i] = new Point(x, 0);
                i++;
            }

            if (board[x][m - 1] == '.') {
                holes[i] = new Point(x, m - 1);
                i++;
            }
        }

        Point[][] prevPoint = new Point[n][m];
        prevPoint[holes[0].x][holes[0].y] = new Point(-1, -1);
        ArrayDeque<Point> bfsQue = new ArrayDeque<Point>();
        bfsQue.offer(new Point(holes[0].x, holes[0].y));

        while (!bfsQue.isEmpty()) {
            Point curPoint = bfsQue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = curPoint.x + dx[d];
                int ny = curPoint.y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                else if (prevPoint[nx][ny] == null && board[nx][ny] == '.') {
                    prevPoint[nx][ny] = new Point(curPoint.x, curPoint.y);
                    bfsQue.offer(new Point(nx, ny));
                }
            }
        }

        int px = holes[1].x;
        int py = holes[1].y;

        while (px != -1) {
            board[px][py] = '@';
            Point p = prevPoint[px][py];
            px = p.x;
            py = p.y;
        }

        board[holes[0].x][holes[0].y] = '@';

        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                char c = board[x][y];
                sb.append(c == '.' ? '@' : c == '@' ? '.' : c);
            }

            sb.append('\n');
        }

        System.out.print(sb);
        br.close();
    }

}
