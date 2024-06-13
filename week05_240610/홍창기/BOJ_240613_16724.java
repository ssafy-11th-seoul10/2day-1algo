import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240613_16724 {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        for (int x = 0; x < n; x++) {
            String line = br.readLine();

            for (int y = 0; y < m; y++) {
                switch (line.charAt(y)) {
                    case 'U':
                        board[x][y] = 0;
                        break;
                    case 'D':
                        board[x][y] = 1;
                        break;
                    case 'L':
                        board[x][y] = 2;
                        break;
                    case 'R':
                        board[x][y] = 3;
                        break;
                }
            }
        }

        int areaCnt = 0;
        int curAreaNum = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (board[x][y] < 0) {
                    continue;
                }

                int cx = x;
                int cy = y;
                curAreaNum--;

                while (board[cx][cy] >= 0) {
                    int curDirection = board[cx][cy];
                    board[cx][cy] = curAreaNum;
                    cx += dx[curDirection];
                    cy += dy[curDirection];
                }

                if (board[cx][cy] == curAreaNum) {
                    areaCnt++;
                }
            }
        }

        System.out.println(areaCnt);
        br.close();
    }

}
