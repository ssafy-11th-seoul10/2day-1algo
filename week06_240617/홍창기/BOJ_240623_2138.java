import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240623_2138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int[] board = new int[n];
        int[] board2 = new int[n];

        for (int i = 0; i < n; i++) {
            board[i] = line.charAt(i) - '0';
            board2[i] = board[i];
        }

        line = br.readLine();
        int[] targetBoard = new int[n];

        for (int i = 0; i < n; i++) {
            targetBoard[i] = line.charAt(i) - '0';
        }

        int minCnt = 1000000;
        int curCnt = 0;

        for (int i = 1; i < n; i++) {
            if (board[i - 1] != targetBoard[i - 1]) {
                curCnt++;
                board[i - 1] ^= 1;
                board[i] ^= 1;

                if (i + 1 < n) {
                    board[i + 1] ^= 1;
                }
            }
        }

        if (board[n - 1] == targetBoard[n - 1]) {
            minCnt = curCnt < minCnt ? curCnt : minCnt;
        }

        curCnt = 1;
        board2[0] ^= 1;
        board2[1] ^= 1;

        for (int i = 1; i < n; i++) {
            if (board2[i - 1] != targetBoard[i - 1]) {
                curCnt++;
                board2[i - 1] ^= 1;
                board2[i] ^= 1;

                if (i + 1 < n) {
                    board2[i + 1] ^= 1;
                }
            }
        }

        if (board2[n - 1] == targetBoard[n - 1]) {
            minCnt = curCnt < minCnt ? curCnt : minCnt;
        }

        System.out.println(minCnt == 1000000 ? -1 : minCnt);
        br.close();
    }

}
