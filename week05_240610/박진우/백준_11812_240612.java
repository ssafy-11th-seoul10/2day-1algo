package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11812 {
	
	static long N;
	static int K, Q;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Long.valueOf(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			if(K==1) {
				sb.append(Math.abs(x-y)).append("\n");
			} else {
				sb.append(com(x, y)).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	static long com(long x, long y) {
		long res = 0;
		
		long x1 = depth(x);
		long y1 = depth(y);
		
		if(x1 < y1) {
			long t = x;
			x = y;
			y = t;
			t = x1;
			x1 = y1;
			y1 = t;
		}
		while(x1!=y1) {
			x = parent(x);
			x1 = depth(x);
			res= res + 1;
		}
		while(x!=y) {
			x = parent(x);
			y = parent(y);
			res = res + 2;
		}
		return res;
	}
	static long parent(long x) {
		return (x-2)/K+1;
	}
	static long depth(long x) {
		if(x==1) return 0;
		
		long l = 1;
		long h = 1;
		while(true) {
			l = l+(long)Math.pow(K, h++);
			if(x<=l) break;
		}
		return h-1;
	}
	
}
