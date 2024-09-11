package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ15990 {

    static int N;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        for(int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(br.readLine());

        long[][] dp = new long[100_001][4];

        dp[1][1] = 1; dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for(int n = 4; n < 100001; n++) {
            dp[n][1] = (dp[n-1][2] + dp[n-1][3]) % 1_000_000_009;
            dp[n][2] = (dp[n-2][1] + dp[n-2][3]) % 1_000_000_009;
            dp[n][3] = (dp[n-3][1] + dp[n-3][2]) % 1_000_000_009;
        }

        for(int tmp : numbers) {
            System.out.println((dp[tmp][1] + dp[tmp][2] + dp[tmp][3]) % 1_000_000_009);
        }
    }
}
