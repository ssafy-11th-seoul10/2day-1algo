import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_240616_6593 {

    static class Point {
        int z, x, y;

        Point(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    static int[] dz = { 0, 0, 0, 0, -1, 1 };
    static int[] dx = { 0, 0, -1, 1, 0, 0 };
    static int[] dy = { -1, 1, 0, 0, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        char[][][] board = new char[30][30][30];

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (l == 0) {
                break;
            }

            ArrayDeque<Point> bfsQue = new ArrayDeque<Point>();

            for (int z = 0; z < l; z++) {
                for (int x = 0; x < r; x++) {
                    String line = br.readLine();

                    for (int y = 0; y < c; y++) {
                        board[z][x][y] = line.charAt(y);

                        if (board[z][x][y] == 'S') {
                            bfsQue.offer(new Point(z, x, y));
                            board[z][x][y] = '#';
                        }
                    }
                }

                br.readLine();
            }

            int curTime = 0;
            boolean trapped = true;

            whileBfs: while (!bfsQue.isEmpty()) {
                curTime++;
                int curIter = bfsQue.size();

                while (curIter-- > 0) {
                    Point curPos = bfsQue.poll();

                    for (int d = 0; d < 6; d++) {
                        int nz = curPos.z + dz[d];
                        int nx = curPos.x + dx[d];
                        int ny = curPos.y + dy[d];

                        if (nz < 0 || nz >= l || nx < 0 || nx >= r || ny < 0 || ny >= c || board[nz][nx][ny] == '#') {
                            continue;
                        }

                        if (board[nz][nx][ny] == 'E') {
                            trapped = false;
                            break whileBfs;
                        }

                        board[nz][nx][ny] = '#';
                        bfsQue.offer(new Point(nz, nx, ny));
                    }
                }
            }

            if (trapped) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(curTime).append(" minute(s).\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

}
