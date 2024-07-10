package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2559 {

    static int N, K;
    static int[] days;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        days = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
            days[i] = Integer.parseInt(st.nextToken());

        int[] sumDay = new int[N+1];

        for(int i = 1; i <= N; i++)
            sumDay[i] = sumDay[i - 1] + days[i - 1];

        int res = Integer.MIN_VALUE;

        for(int start = K; start <= N; start++)
            res = Math.max(res, sumDay[start] - sumDay[start - K]);

        System.out.println(res);
    }
}