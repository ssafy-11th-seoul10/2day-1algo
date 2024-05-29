package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15652 {
	static int N, M;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		comb(0, 1, "");
		System.out.print(sb);
	}
	
	static void comb(int a, int k, String s) {
		if(M==a) {
			sb.append(s).append("\n");
			return;
		}
		for(int i = k; i<N+1; i++) {
			comb(a+1, i, s+i+" ");
		}
	}
}
