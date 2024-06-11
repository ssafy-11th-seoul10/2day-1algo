package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon9765 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int t =0;
		
		while(t++<T) {
			int n = Integer.parseInt(in.readLine());
			int[][] arr = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			for(int i=0; i<2; i++){
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j+1] = Integer.parseInt(st.nextToken());
				}
            }

			dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
            }
            int ans =0;
            ans = Math.max(dp[0][n], dp[1][n]);
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
