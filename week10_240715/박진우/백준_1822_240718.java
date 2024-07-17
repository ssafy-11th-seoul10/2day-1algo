package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1822 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(B);
		
		StringBuilder sb = new StringBuilder();
		int s1 = 0;
		int s2 = 0;
		int cnt = N;
		while(s1<N && s2<M) {
			if(A[s1]==B[s2]) {
				A[s1]= 0;
				s1++;
				s2++;
				cnt--;
			} else if(A[s1]>B[s2]) {
				s2++;
			} else {
				s1++;
			}
		}
		for(int i = 0; i<N; i++) {
			if(A[i]!=0)
				sb.append(A[i]).append(" ");
		}
		System.out.println(cnt);
		if(cnt!=0)
			System.out.println(sb);
		
	}
}
