package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj14950 {
	static int N, M, T;
	static int[] root;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		root = new int[N];
		for(int i = 0; i<N; i++) {
			root[i] = i;
		}
		
		b14950 b[]=  new b14950[M];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			b14950 B = new b14950(from, to, weight);
			b[i] = B;
		}
		Arrays.sort(b);
		
		int w = 0;
		long sum = 0;
		
		for(int i = 0; i<M; i++) {
			if(find(b[i].from)==find(b[i].to)) {
				continue;
			}
			union(b[i].from, b[i].to);
			sum = sum + b[i].weight + T*w++;
		}
		
		System.out.println(sum);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x!=y) {
			root[y]=x;
		}
	}
	static int find(int x) {
		if(root[x] == x)
			return x;
		return root[x] = find(root[x]);
	}
}
class b14950 implements Comparable<b14950>{
	
	int from;
	int to;
	int weight;
	
	public b14950(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(b14950 o) {
		return this.weight-o.weight;
	}
	
}