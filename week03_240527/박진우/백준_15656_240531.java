package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15656 {
	static int N, M;
	static int arr[];
	static int res[];
	static boolean[] used;
			
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
	
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		res = new int[M];
		used = new boolean[N];
		
		pmtt(0, 0);
		
		System.out.print(sb);
	}
	
	static void pmtt(int len, int start) {
		if(M==len) {
			for(int i = 0; i<res.length; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i<N; i++) {
				used[i] = true;
				res[len] = arr[i];
				pmtt(len+1, i+1);
				used[i] = false;
		}
	}
}
