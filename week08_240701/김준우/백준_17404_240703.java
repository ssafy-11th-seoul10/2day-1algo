import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, S, mini;
	static int[][] arr;
	static int[][][] dp;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3]; dp = new int[N][3][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					dp[0][i][j] = arr[0][i];
				} else {
					dp[0][i][j] = 2001;
				}
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = 1_000_001;
				}
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if (k != l) {
							if (dp[i][j][k] > dp[i-1][j][l] + arr[i][k]) {
								dp[i][j][k] = dp[i-1][j][l] + arr[i][k];
							}
						}
					}
				}
			}
		}
		int ans = 1_000_001;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != j && ans > dp[N-1][i][j]) {
					ans = dp[N-1][i][j];
				}
			}
		}
		System.out.println(ans);
		
		
		
		
	}
}




