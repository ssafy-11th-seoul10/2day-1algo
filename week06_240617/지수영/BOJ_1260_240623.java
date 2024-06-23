import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_240623 {
	
	public static int N, M, V;
	public static List<Integer>[] graph;
	public static StringBuilder sb;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}
		
		for (int i = 0; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		visited = new boolean[N+1];
		DFS(V);
		sb.append("\n");
		visited = new boolean[N+1];
		BFS(V);
		System.out.println(sb);
	}
	
	public static void DFS(int curr) {
		visited[curr] = true;
		sb.append(curr).append(" ");
		for(int next: graph[curr]) {
			if(!visited[next]) {
				DFS(next);
			}
		}
	}
	
	public static void BFS(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(" ");
			for(int next: graph[curr]) {
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
