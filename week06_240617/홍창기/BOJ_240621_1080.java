import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240621_1080 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        for (int x = 0; x < n; x++) {
            String line = br.readLine();

            for (int y = 0; y < m; y++) {
                board[x][y] = line.charAt(y) - '0';
            }
        }

        int[][] targetBoard = new int[n][m];

        for (int x = 0; x < n; x++) {
            String line = br.readLine();

            for (int y = 0; y < m; y++) {
                targetBoard[x][y] = line.charAt(y) - '0';
            }
        }

        int cnt = 0;

        for (int x = 2; x < n; x++) {
            for (int y = 2; y < m; y++) {
                if (board[x - 2][y - 2] != targetBoard[x - 2][y - 2]) {
                    cnt++;

                    for (int xx = x - 2; xx <= x; xx++) {
                        for (int yy = y - 2; yy <= y; yy++) {
                            board[xx][yy] ^= 1;
                        }
                    }
                }
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (board[x][y] != targetBoard[x][y]) {
                    cnt = -1;
                    break;
                }
            }

            if (cnt == -1) {
                break;
            }
        }

        System.out.println(cnt);
        br.close();
    }

}
