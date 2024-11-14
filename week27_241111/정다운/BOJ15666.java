package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15666 {
    static int N, M;
    static int[] arr;

    static int[] perm;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();;

    public static void permutation(int depth) {

        if(depth == M) {
            for(int i = 0; i < M; i++)
                sb.append(perm[i]).append(" ");

            sb.append("\n");

            return;
        }

        int flag = 0;

        for(int i = 0; i < N; i++) {
            if(depth != 0 && perm[depth - 1] > arr[i])
                continue;
            if(flag == arr[i])
                continue;

            perm[depth] = arr[i];
            flag = arr[i];
            permutation(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        perm = new int[M];
        visited = new boolean[N];

        permutation(0);
        System.out.println(sb.toString());
    }
}
