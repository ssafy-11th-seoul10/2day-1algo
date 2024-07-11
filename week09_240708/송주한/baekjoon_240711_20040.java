package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_240711_20040 {

	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		for(int i=0;i<n;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(find(a)==find(b)) {
				System.out.println(i+1);
				return;
			}
			else {
				union(a,b);
			}
		}
		
		System.out.println(0);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a<b) {
			parent[b] =a;
		}else {
			parent[a] =b;
		}
		
	}

	private static int find(int a) {
		if(a == parent[a]) return a;
		return find(parent[a]);
	}
}
