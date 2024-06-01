package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2293 {
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[K+1];
		dp[0] = 1;
		
		int[] coin = new int[N+1];
		for(int i = 1; i<=N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			for(int j = coin[i]; j<=K; j++) {
				dp[j] = dp[j]+dp[j-coin[i]];
			}
		}
		System.out.println(dp[K]);
	}
	
}
