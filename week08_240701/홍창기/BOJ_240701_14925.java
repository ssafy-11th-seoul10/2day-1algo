import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240701_14925 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[m + 1][n + 1];

        for (int x = 1; x <= m; x++) {
            String line = br.readLine();

            for (int y = 1; y <= n; y++) {
                board[x][y] = line.charAt((y - 1) * 2) == '0' ? 0 : 1;
                board[x][y] += board[x][y - 1] + board[x - 1][y] - board[x - 1][y - 1];
            }
        }

        int maxSquareLen = 0;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int low = 0;
                int high = Math.min(m - x, n - y) + 1;

                while (low + 1 < high) {
                    int mid = (low + high) / 2;

                    if (board[x + mid][y + mid] - board[x + mid][y] - board[x][y + mid] + board[x][y] == 0) {
                        low = mid;
                    } else {
                        high = mid;
                    }
                }

                maxSquareLen = low > maxSquareLen ? low : maxSquareLen;
            }
        }

        System.out.println(maxSquareLen);
        br.close();
    }

}
