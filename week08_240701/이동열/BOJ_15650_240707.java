package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {

    private static int N,M;
    private static StringBuilder sb;
    private static boolean[] visited;

    private static void sol(int depth, int prev){
        if (depth == M) {
            for (int i = 1; i <= N; i++) {
                if(visited[i]){
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        for (int i = prev; i <= N; i++) {
            if(!visited[i]){
                visited[i] = true;
                sol(depth+1, i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        visited = new boolean[N+1];
        sol(0,1);
        System.out.println(sb);
    }

}
