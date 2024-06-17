package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ15650 {

    static int N, M;

    static int[] combi;

    static StringBuilder sb;

    public static void combination(int depth, int start) {

        if(depth == M) {
            sb = new StringBuilder();

            for(int i = 0; i < M; i++)
                sb.append(combi[i]).append(" ");

            System.out.println(sb);

            return;
        }

        for(int num = start; num <= N; num ++) {
            combi[depth] = num;
            combination(depth + 1, num + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        combi = new int[M];

        combination(0, 1);
    }
}
