package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dessert= new int[M][N];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				dessert[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[M][N];
		
		for(int i = 0; i<M; i++) {
			dp[i][0] = dessert[i][0];

		}
		
		for(int i = 1; i<N; i++) {
			for(int j = 0; j<M; j++) {
				for(int sel = 0; sel < M; sel++) {
					if(j==sel) {
						dp[j][i] = Math.max(dp[j][i], dp[sel][i-1]+dessert[j][i]/2);
					} else {
						dp[j][i] = Math.max(dp[j][i], dp[sel][i-1]+dessert[j][i]);
					}
				}
			}
		}
		int high = 0;
		for(int i = 0; i<M; i++) {
			if(dp[i][N-1]>high) {
				high = dp[i][N-1];
			}
		}
		System.out.print(high);
	}
}
