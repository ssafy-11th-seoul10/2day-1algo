package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ15988 {

    static int testCase;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());

        dp = new long[1_000_001];

        dp[1] = 1; dp[2] = 2; dp[3] = 4;

        for(int number = 4; number < 1000001; number++)
            dp[number] = (dp[number - 1] + dp[number - 2] + dp[number - 3]) % 1_000_000_009;

        for(int test = 0; test < testCase; test++) {
            int temp = Integer.parseInt(br.readLine());

            System.out.println(dp[temp]);
        }
    }
}
