package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1240 {

    static int N, M;
    static List<int[]>[] graph;

    static int res = 0;
    static boolean[] visited;

    public static void dfs(int node, int dest, int leng) {

        if(node == dest) {
            res = leng;
            return;
        }

        visited[node] = true;

        for(int[] nextPos : graph[node]) {
            int dst = nextPos[0]; int le = nextPos[1];

            if(!visited[dst])
                dfs(dst, dest, leng + le);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N+1];

        for(int i = 1; i < N + 1; i++)
            graph[i] = new ArrayList<int[]>();

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int leng = Integer.parseInt(st.nextToken());

            graph[start].add(new int[] {dest, leng});
            graph[dest].add(new int[] {start, leng});
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            res = 0;
            visited = new boolean[N+1];

            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            dfs(start, dest, 0);

            System.out.println(res);
        }
    }
}
