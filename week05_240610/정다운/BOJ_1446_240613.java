package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1446 {

    static int N, D;

    static int[][] short_route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        short_route = new int[N][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int route = Integer.parseInt(st.nextToken());

            short_route[i][0] = start; short_route[i][1] = end; short_route[i][2] = route;
        }

        // 지름길이 9999 -> 10000, 길이가 10000 인 경우, 아래 dp 갱신 위해 2배로 인덱스를 증가시켜준다.
        int[] dp = new int[20003];

        for(int km = 0; km < D+1; km++) {

            if(dp[km] == 0)
                dp[km] = km;

            if(km != 0)
                dp[km] = Math.min(dp[km - 1] + 1, dp[km]);

            for(int r_idx = 0; r_idx < N; r_idx++) {
                if(short_route[r_idx][0] == km) {

                    if(dp[short_route[r_idx][1]] == 0)
                        dp[short_route[r_idx][1]] = short_route[r_idx][1];
                    // 인덱스 깨질 수 있는 로직
                    dp[short_route[r_idx][1]] = Math.min(dp[km] + short_route[r_idx][2], dp[short_route[r_idx][1]]);

                    //System.out.println(dp[short_route[r_idx][1]]);
                }
            }
            //System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[D]);
    }
}
