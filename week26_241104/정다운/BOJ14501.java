package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ14501 {

    static int N;
    static int[] T;
    static int[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = new int[N]; P = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // DP
        int[] dp = new int[N + 1];

        for(int start = 0; start < N; start++) {
            // start ~ start + 기간
            // dp[끝나는 날] = 원래 dp[끝나는 날] vs (dp[시작 날] + (해당 날짜의 Payment))
            if(start + T[start] <= N)
                dp[start + T[start]] = Math.max(dp[start + T[start]], dp[start] + P[start]);

            // 다음 날 => payment 는 이전 날짜 그대로 들고 감 vs dp[다음 날]
            dp[start + 1] = Math.max(dp[start], dp[start + 1]);
        }

        System.out.println(dp[N]);
    }
}
