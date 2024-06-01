package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15657 {
	static int N, M;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		comb(0, 0, "");
		System.out.print(sb);
	}
	
	static void comb(int a, int k, String s) {
		if(M==a) {
			sb.append(s).append("\n");
			return;
		}
		for(int i = k; i<N; i++) {
			comb(a+1, i, s+arr[i]+" ");
		}
	}
}
