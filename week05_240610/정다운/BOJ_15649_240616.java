package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15649 {

    static int N, M;
    static int[] perm;
    static boolean[] visited;

    static StringBuilder sb;

    public static void permutation(int depth) {

        if(depth == M) {

            sb = new StringBuilder();
            for(int i = 0; i < M; i++)
                sb.append(perm[i]).append(" ");

            System.out.println(sb);
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            perm[depth] = i;

            permutation(depth+1);

            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        perm = new int[M];
        visited = new boolean[N+1];

        permutation(0);
    }
}
