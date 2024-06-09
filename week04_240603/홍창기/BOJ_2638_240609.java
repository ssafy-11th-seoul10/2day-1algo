import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2638_240609 {

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
        int[][] board = new int[n][m];

        for (int x = 0; x < n; x++) {
            String line = br.readLine();

            for (int y = 0; y < m; y++) {
                board[x][y] = line.charAt(y * 2) - '0';
            }
        }

        int curTime = 0;

        while (true) {
            int[][] visitCount = new int[n][m];
            ArrayDeque<Point> bfsQue = new ArrayDeque<Point>();
            ArrayList<Point> cheeseToMelt = new ArrayList<Point>();
            visitCount[0][0] = 1;
            bfsQue.offer(new Point(0, 0));

            while (!bfsQue.isEmpty()) {
                Point curPoint = bfsQue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = curPoint.x + dx[d];
                    int ny = curPoint.y + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }

                    if (board[nx][ny] == 1) {
                        if (++visitCount[nx][ny] == 2) {
                            cheeseToMelt.add(new Point(nx, ny));
                        }
                    } else {
                        if (visitCount[nx][ny] == 0) {
                            visitCount[nx][ny] = 1;
                            bfsQue.offer(new Point(nx, ny));
                        }
                    }
                }
            }

            if (cheeseToMelt.isEmpty()) {
                break;
            }

            curTime++;

            for (Point p : cheeseToMelt) {
                board[p.x][p.y] = 0;
            }
        }

        System.out.println(curTime);
        br.close();
    }

}
