import java.io.*;
import java.util.*;

public class Main {

    private static int readInt() throws IOException{
        int c, n = 0, flag = 1;

        while((c = System.in.read()) > 32){
            if (c == '-') {
                flag = -1;
                continue;
            }
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return flag * n;
    }

    private static int getMaxProfit(int[] board, int N, int S, int T){
        int[][] dp = new int[T][N + 1];

        for (int turn = 1; turn < T; turn++){
            Arrays.fill(dp[turn], -1_000_000);
        }

        for (int turn = 1; turn < T; turn++) {
            for (int i = turn; i <= Math.min(turn * S, N); i++) {
                int curMaxProfit = Integer.MIN_VALUE;

                for (int dice = 1; dice <= Math.min(S, i); dice++) {
                    curMaxProfit = Math.max(curMaxProfit, dp[turn - 1][i - dice] + board[i]);
                }
                dp[turn][i] = curMaxProfit;
            }
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int turn = 1; turn < T; turn++) {
            for (int dice = 0; dice < S; dice++) {
                maxProfit = Math.max(maxProfit, dp[turn][N - dice]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        while(true) {
            int N = readInt();
            if (N == 0) break;
            int S = readInt(), T = readInt();
            int[] board = new int[N + 1];

            for (int i = 1; i <= N; i++){
                board[i] = readInt();
            }

            sb.append(getMaxProfit(board, N, S, T)).append('\n');
        }
        System.out.print(sb);
    }

}
