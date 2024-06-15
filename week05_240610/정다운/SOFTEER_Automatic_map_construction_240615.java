package Softeer;

import java.io.*;
import java.util.*;

public class Automatic_map_construction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[0] = 2;
        dp[1] = 3;

        for(int i = 2; i < N + 1; i++) {

            dp[i] = dp[i-1] + (dp[i-1] - 1);
        }

        System.out.println(dp[N] * dp[N]);
    }
}
