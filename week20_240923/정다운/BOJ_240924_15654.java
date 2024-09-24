package baekjoon;

import java.util.*;
import java.io.*;

// 코테하곤 상관 없는데, stringbuilder 함부러 초기화 X, 초기화는 반드시 1번만 써..

public class BOJ15654 {

    static int N, M;
    static int[] perm;
    static List<Integer> data;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void permutation(int depth) {

        if(depth == M) {
            for(int i = 0; i < M; i++) {
                if(i == M - 1)
                    sb.append(perm[i]);
                else
                    sb.append(perm[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i])
                continue;

            visited[i] = true;
            perm[depth] = data.get(i);

            permutation(depth + 1);

            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            data.add(Integer.parseInt(st.nextToken()));

        Collections.sort(data);
        visited = new boolean[N];
        perm = new int[M];

        permutation(0);

        System.out.println(sb);
    }
}
