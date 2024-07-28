package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1260 {

    private static int N,M,V;
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static StringBuilder sb;

    private static void DFS(int s){
        visited[s] = true;
        sb.append(s).append(" ");
        for(Integer next : graph[s]){
            if(!visited[next]){
                DFS(next);
            }
        }
    }

    private static void BFS(int start){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start] = true;
        while (!deque.isEmpty()){
            int curr = deque.poll();
            sb.append(curr).append(" ");
            for(Integer next : graph[curr]){
                if(!visited[next]){
                    deque.add(next);
                    visited[next] = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new List[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        visited = new boolean[N+1];
        sb = new StringBuilder();
        DFS(V);
        sb.append("\n");
        visited = new boolean[N+1];
        BFS(V);
        System.out.println(sb);


    }

}
