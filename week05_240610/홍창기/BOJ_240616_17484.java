import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240616_17484 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n + 1][m + 1];

        for (int x = 1; x <= n; x++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int y = 1; y <= m; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] memo = new int[n + 1][m + 1][3];

        for (int x = 1; x <= n; x++) {
            memo[x][1][0] = 1000;
            memo[x][1][1] = memo[x - 1][1][2] + board[x][1];
            memo[x][1][2] = Math.min(memo[x - 1][2][0], memo[x - 1][2][1]) + board[x][1];

            for (int y = 2; y < m; y++) {
                memo[x][y][0] = Math.min(memo[x - 1][y - 1][1], memo[x - 1][y - 1][2]) + board[x][y];
                memo[x][y][1] = Math.min(memo[x - 1][y][0], memo[x - 1][y][2]) + board[x][y];
                memo[x][y][2] = Math.min(memo[x - 1][y + 1][0], memo[x - 1][y + 1][1]) + board[x][y];
            }

            memo[x][m][0] = Math.min(memo[x - 1][m - 1][1], memo[x - 1][m - 1][2]) + board[x][m];
            memo[x][m][1] = memo[x - 1][m][0] + board[x][m];
            memo[x][m][2] = 1000;
        }

        int ans = 1000;

        for (int y = 1; y <= m; y++) {
            if (memo[n][y][0] < ans) {
                ans = memo[n][y][0];
            }

            if (memo[n][y][1] < ans) {
                ans = memo[n][y][1];
            }

            if (memo[n][y][2] < ans) {
                ans = memo[n][y][2];
            }
        }

        System.out.println(ans);
        br.close();
    }

}
