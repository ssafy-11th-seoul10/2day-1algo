package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ10974 {

    static int N;

    static int[] perm;
    static boolean[] visited;

    static StringBuilder sb;

    public static void permutation(int depth) {

        if(depth == N) {

            sb = new StringBuilder();

            for(int i=0; i<N; i++)
                sb.append(perm[i]).append(" ");

            System.out.println(sb);
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(visited[i - 1])
                continue;

            perm[depth] = i;
            visited[i - 1] = true;

            permutation(depth + 1);

            visited[i - 1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        perm = new int[N];
        visited = new boolean[N];

        permutation(0);
    }
}
