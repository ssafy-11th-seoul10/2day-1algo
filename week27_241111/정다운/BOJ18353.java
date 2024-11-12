package baekjoon;
// https://blackvill.tistory.com/268
// LCS, 증가 대신 감소 DP!

import java.util.*;
import java.io.*;

public class BOJ18353 {

    static int N;
    static int[] solider;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        solider = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            solider[i] = Integer.parseInt(st.nextToken());

        // DP - ( 감소하는 최장길이 부분수열 )

        // 병사 하나를 골라서
        int res = 0;

        for(int i = 1; i <= N; i++) {
            // 시작은 1, 병사 1명
            dp[i] = 1;

            for(int j = 1; j < i; j++) {
                // j = start ~ i 까지
                if(solider[j] > solider[i]) {
                    //dp[j] = 이전까지 감소한 부분 수열의 길이, 현재 길이 vs 이전까지 만들어진 길이 + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(res, dp[i]);
        }

        System.out.println(N - res);
    }
}
