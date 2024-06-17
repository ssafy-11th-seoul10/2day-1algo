package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ14248 {

    static int N;
    static int[] stones;
    static boolean[] visited;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        stones = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            stones[i] = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {start-1, stones[start - 1]});

        int cnt = 1;
        visited[start - 1] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int cur_idx = tmp[0]; int move = tmp[1];

            if(cur_idx + move < N && ! visited[cur_idx + move]) {
                visited[cur_idx + move] = true;
                queue.add(new int[] {cur_idx + move, stones[cur_idx + move]});
                cnt++;
            }

            if(cur_idx - move > -1 && !visited[cur_idx - move]) {
                visited[cur_idx - move] = true;
                queue.add(new int[] {cur_idx - move, stones[cur_idx - move]});
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
