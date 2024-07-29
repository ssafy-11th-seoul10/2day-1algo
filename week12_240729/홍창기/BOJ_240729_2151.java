import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_240729_2151 {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class PointInfo {
        int x, y, d, val;

        PointInfo(int x, int y, int d, int val) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        int rx = 0;
        int ry = 0;

        for (int x = 0; x < n; x++) {
            String line = br.readLine();

            for (int y = 0; y < n; y++) {
                board[x][y] = line.charAt(y);

                if (board[x][y] == '#') {
                    rx = x;
                    ry = y;
                }
            }
        }

        int[][] mirrorCnt = new int[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                mirrorCnt[x][y] = 1000000;
            }
        }

        ArrayDeque<PointInfo> queue = new ArrayDeque<PointInfo>();
        queue.offer(new PointInfo(rx, ry, 0, 0));
        queue.offer(new PointInfo(rx, ry, 1, 0));
        queue.offer(new PointInfo(rx, ry, 2, 0));
        queue.offer(new PointInfo(rx, ry, 3, 0));
        int ans = -1;

        while (!queue.isEmpty()) {
            PointInfo pointInfo = queue.poll();
            int d = pointInfo.d;
            int nx = pointInfo.x + dx[d];
            int ny = pointInfo.y + dy[d];

            while (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != '*') {
                mirrorCnt[nx][ny] = Math.min(mirrorCnt[nx][ny], pointInfo.val);

                if (board[nx][ny] == '#') {
                    ans = pointInfo.val;
                    break;
                } else if (board[nx][ny] == '!') {
                    board[nx][ny] = ',';

                    if (d <= 1) {
                        queue.offer(new PointInfo(nx, ny, 2, pointInfo.val + 1));
                        queue.offer(new PointInfo(nx, ny, 3, pointInfo.val + 1));
                    } else {
                        queue.offer(new PointInfo(nx, ny, 0, pointInfo.val + 1));
                        queue.offer(new PointInfo(nx, ny, 1, pointInfo.val + 1));
                    }
                }

                nx += dx[d];
                ny += dy[d];
            }

            if (ans >= 0) {
                break;
            }
        }

        System.out.println(ans);
        br.close();
    }

}
