package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2294 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[K+1];
		int[] coin = new int[N+1];
		for(int i = 1; i<=K; i++) {
			dp[i]=9999999;
		}
		
		for(int i = 1; i<=N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = coin[i]; j<=K; j++){
				dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
			}
		}
		if(dp[K]==9999999)
			System.out.println(-1);
		else
		System.out.println(dp[K]);
	}
}
