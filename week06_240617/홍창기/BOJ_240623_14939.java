import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_240623_14939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[10][10];
        int[][] curBoard = new int[10][10];

        for (int x = 0; x < 10; x++) {
            String line = br.readLine();

            for (int y = 0; y < 10; y++) {
                board[x][y] = line.charAt(y) == '#' ? 0 : 1;
            }
        }

        int minCnt = 1000;

        for (int b = 0; b < 1024; b++) {
            // copy board

            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    curBoard[x][y] = board[x][y];
                }
            }

            int curCnt = 0;

            // 0th row

            for (int y = 0; y < 10; y++) {
                if ((b & (1 << y)) != 0) {
                    curCnt++;
                    curBoard[0][y] ^= 1;
                    curBoard[1][y] ^= 1;

                    if (y >= 1) {
                        curBoard[0][y - 1] ^= 1;
                    }

                    if (y < 9) {
                        curBoard[0][y + 1] ^= 1;
                    }
                }
            }

            // other row

            for (int x = 1; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    if (curBoard[x - 1][y] == 1) {
                        curCnt++;
                        curBoard[x - 1][y] = 0;
                        curBoard[x][y] ^= 1;

                        if (y >= 1) {
                            curBoard[x][y - 1] ^= 1;
                        }

                        if (y < 9) {
                            curBoard[x][y + 1] ^= 1;
                        }

                        if (x < 9) {
                            curBoard[x + 1][y] ^= 1;
                        }
                    }
                }
            }

            boolean allZeros = true;

            for (int y = 0; y < 10; y++) {
                if (curBoard[9][y] == 1) {
                    allZeros = false;
                    break;
                }
            }

            if (allZeros) {
                minCnt = curCnt < minCnt ? curCnt : minCnt;
            }
        }

        System.out.println(minCnt == 1000 ? -1 : minCnt);
        br.close();
    }

}
