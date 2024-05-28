package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1707 {
	
	static int V, E;
	static ArrayList<Integer>[] list;
	static int[] part;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			
			for(int j = 1; j<V+1; j++) {
				list[j] = new ArrayList<>();
			}
			
			for(int j = 0; j<E; j++) {
				st = new StringTokenizer (br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
			
				list[A].add(B);
				list[B].add(A);
			}
			part = new int[V+1];
			if(isTrue(1))
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		System.out.print(sb);
		
	}
	
	static boolean isTrue(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i<V+1; i++) {
			if(part[i]==0) {
				part[i] = 1;
				q.add(i);
			}
			while(!q.isEmpty()) {
				int p = q.poll();
				
				for(int next : list[p]) {
					if(part[next]==part[p]) {
						return false;
						}
					if(part[next]==0) {
						q.add(next);
						if(part[p]==1) {
							part[next]=2;
						} else {
							part[next]=1;
						}
					}
				}
			}
		}
		return true;
	}
}
