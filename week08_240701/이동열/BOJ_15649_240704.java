package boj;

import java.io.*;
import java.util.*;

public class BOJ15649 {

    private static int N,M;
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb;

    private static void sol(int depth){
        if(depth == M){
            for (Integer num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                arr[depth] = i;
                visited[i] = true;
                sol(depth+1);
                visited[i] = false;
                arr[depth] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        arr = new int[M];
        sb = new StringBuilder();
        sol(0);
        System.out.println(sb);
    }
}