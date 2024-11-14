package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ15657 {

    static int N, M;
    static int[] arr;
    static int[] perm;
    static boolean[] visited;
    static StringBuilder sb;

    public static void permutation(int depth, int start) {

        if(depth == M) {

            sb = new StringBuilder();
            for(int i = 0; i < M; i++)
                sb.append(perm[i]).append(" ");

            System.out.println(sb.toString());
            return;
        }

        for(int i = start; i < N; i++) {

            perm[depth] = arr[i];
            permutation(depth + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        perm = new int[M]; visited = new boolean[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // perm
        Arrays.sort(arr);
        permutation(0, 0);
    }
}
