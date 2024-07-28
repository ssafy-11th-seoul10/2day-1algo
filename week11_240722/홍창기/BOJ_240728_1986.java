import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240728_1986 {

    static int[] dx = { 0, 0, -1, -1, -1, 1, 1, 1 };
    static int[] dy = { -1, 1, -1, 0, 1, -1, 0, 1 };
    static int[] dx2 = { -2, -2, -1, -1, 1, 1, 2, 2 };
    static int[] dy2 = { -1, 1, -2, 2, -2, 2, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        st = new StringTokenizer(br.readLine(), " ");
        int queenNum = Integer.parseInt(st.nextToken());
        int[][] queens = new int[queenNum][2];

        for (int i = 0; i < queenNum; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            queens[i][0] = x;
            queens[i][1] = y;
            board[x][y] = 1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int knightNum = Integer.parseInt(st.nextToken());
        int[][] knights = new int[knightNum][2];

        for (int i = 0; i < knightNum; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            knights[i][0] = x;
            knights[i][1] = y;
            board[x][y] = 2;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int pawnNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i < pawnNum; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 3;
        }

        for (int[] queen : queens) {
            for (int d = 0; d < 8; d++) {
                int nx = queen[0] + dx[d];
                int ny = queen[1] + dy[d];

                while (nx >= 0 && nx < n && ny >= 0 && ny < m && (board[nx][ny] == 0 || board[nx][ny] == 4)) {
                    board[nx][ny] = 4;
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }

        for (int[] knight : knights) {
            for (int d = 0; d < 8; d++) {
                int nx = knight[0] + dx2[d];
                int ny = knight[1] + dy2[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 4;
                }
            }
        }

        int ans = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (board[x][y] == 0) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

}
