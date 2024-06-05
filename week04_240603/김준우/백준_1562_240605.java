import java.io.*;
import java.util.*;



class Main {
	static int[][][][] dp;
	
	public static void nextUpdate(int n) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					if (i < 9) {
						if (i == k) {
							dp[j][k+1][i+1][n] += dp[j][k][i][n-1];
							dp[j][k+1][i+1][n] %= 1_000_000_000;
						} else {
							dp[j][k][i+1][n] += dp[j][k][i][n-1];
							dp[j][k][i+1][n] %= 1_000_000_000;
						}
					}
					if (i > 0) {
						if (i == j) {
							dp[j-1][k][i-1][n] += dp[j][k][i][n-1];
							dp[j-1][k][i-1][n] %= 1_000_000_000;

						} else {
							dp[j][k][i-1][n] += dp[j][k][i][n-1];
							dp[j][k][i-1][n] %= 1_000_000_000;
						}
					}
				}
			}
		}
	}
	
	
	public static int solution(int N) {
		for (int i = 2; i < N+1; i++) {
			nextUpdate(i);
		}
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += dp[0][9][i][N];
			ans %= 1_000_000_000;
//			System.out.println(ans);
		}
		return ans;
	}
	public static void initDP() {
		dp = new int[10][10][10][101];
		for (int i = 1; i < 10; i++) {
			dp[i][i][i][1] = 1;
		}
	}
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		initDP();
//		long ans = 0;
//		for (int i = 1; i < 41; i++) {
//			initDP();
//			ans += solution(i);
//		}
		System.out.println(solution(N));
	}
}