다이나믹 사용
이전과정에서 중복된 수를 줄이기 위해 2차원 dp로 나눠서 해결
사용한 수를 기준으로 분할

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        int[][] dp = new int[11111][4];
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][2] + dp[i - 2][1];
            dp[i][3] = dp[i - 3][3] + dp[i - 3][2] + dp[i - 3][1];
        }

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            System.out.println(dp[x][1] + dp[x][2] + dp[x][3]);
        }
    }
}
