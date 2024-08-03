package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int num[] = new int[N+M];
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st= new StringTokenizer(br.readLine());
		for(int i = N; i<M+N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N+M; i++) {
			sb.append(num[i]).append(" ");
		}
		System.out.print(sb);
	}
}
