import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1743_240530 {

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
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }

        ArrayDeque<Point> bfsQue = new ArrayDeque<Point>();
        int maxArea = 0;

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                if (board[x][y] != 1) {
                    continue;
                }

                board[x][y] = 2;
                bfsQue.offer(new Point(x, y));
                int curArea = 1;

                while (!bfsQue.isEmpty()) {
                    Point curPos = bfsQue.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = curPos.x + dx[d];
                        int ny = curPos.y + dy[d];

                        if (nx < 1 || nx > n || ny < 1 || ny > m || board[nx][ny] != 1) {
                            continue;
                        }

                        board[nx][ny] = 2;
                        bfsQue.offer(new Point(nx, ny));
                        curArea++;
                    }
                }

                maxArea = curArea > maxArea ? curArea : maxArea;
            }
        }

        System.out.println(maxArea);
        br.close();
    }

}
