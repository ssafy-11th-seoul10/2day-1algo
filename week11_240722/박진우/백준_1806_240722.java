package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] num = new int[N+1];
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int low = Integer.MAX_VALUE;
		
		while(end<=N) {
			
			if(sum>=S) {
				sum = sum-num[start];
				start++;
				if(low>end-start+1) {
					low = end-start+1;
				}
			} else {
				sum = sum + num[end];
				end++;
			}
		}
		if(low == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(low);
	}
}
