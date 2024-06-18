package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ11659 {

    static int N, M;
    static int[] number_sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number_sum = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N+1; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(i == 1)
                number_sum[i] = tmp;
            else
                number_sum[i] = number_sum[i-1] + tmp;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(number_sum[end] - number_sum[start - 1]);
        }
    }
}
