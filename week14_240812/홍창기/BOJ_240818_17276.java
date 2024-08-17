import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_240818_17276 {

    static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (d < 0) {
                d += 360;
            } else if (d == 360) {
                d = 0;
            }

            d /= 45;
            int n2 = n / 2;
            int[][] board = new int[n][n];

            for (int x = 0; x < n; x++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int y = 0; y < n; y++) {
                    board[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            ArrayDeque<Integer> dq = new ArrayDeque<Integer>();

            for (int i = n / 2; i >= 1; i--) {
                for (int j = 0; j < 8; j++) {
                    dq.offerLast(board[n2 + i * dx[j]][n2 + i * dy[j]]);
                }

                for (int j = 0; j < d; j++) {
                    dq.offerFirst(dq.pollLast());
                }

                for (int j = 0; j < 8; j++) {
                    board[n2 + i * dx[j]][n2 + i * dy[j]] = dq.pollFirst();
                }
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    sb.append(board[x][y]).append(' ');
                }

                sb.append('\n');
            }
        }

        System.out.print(sb);
        br.close();
    }

}
