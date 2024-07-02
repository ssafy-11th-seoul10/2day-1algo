package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_240702_2252 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] count = new int[n+1];
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			count[b]++;
			arr[a].add(b);
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(count[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int a = q.poll();
			sb.append(a).append(" ");
			
			for(int i=0;i<arr[a].size();i++) {
				int b = arr[a].get(i);
				count[b]--;
				if(count[b] == 0) {
					q.offer(b);
				}
			}
		}
		
		System.out.println(sb);
		
	}
}
