package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ10164 {

    static int N, M, K;
    static int[][] graph;
    static int cnt = 0;

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }

    public static void dfs(int x, int y, boolean flag) {

        if(x == N - 1 && y == M - 1) {
            if(flag)
                cnt++;
            return;
        }

        if(graph[x][y] == K)
            flag = true;

        if(inRange(x + 1, y))
            dfs(x + 1, y, flag);
        if(inRange(x, y + 1))
            dfs(x, y + 1, flag);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++) {
                graph[i][j] = i * M + (j + 1);
            }

        if(K != 0)
            dfs(0, 0, false);
        else
            dfs(0, 0, true);

        System.out.println(cnt);
    }

}
