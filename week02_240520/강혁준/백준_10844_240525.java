import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	final static int REM = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());

		// process
		// 길이가 1인 계단 수
		// 1, 2, 3, 4, 5, 6, 7, 8, 9

		// 길이가 2인 계단 수
		// 10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98

		// 길이가 3인 계단 수
		// 101, 121, 123, 210, 212, 232, 234, ...

		// 길이가 4인 계단 수
		// 1010, 1012, 1210, 1212, 1232, 1234, 2101, 2121, 2123, ...

		// 길이가 N일 때 계단수의 수는
		// 맨 앞자리의 수가 1일 때는 N = N - 2일 때 맨 앞자리 수가 1일 때 가능한 수와
		// N = N - 1일 때 맨 앞자리 수가 2일 때 가능한 수의 합

		// 맨 앞자리의 수가 2 ~ 8일 때는 N = N - 1일 때 맨 앞자리 수가 현재 수의
		// -1, +1을 했을 때 가능 한 수의 합

		// 맨 앞자리의 수가 9일 때는 N = N - 1의 맨 앞자리 수가 8일 때의 가능한 수

		// 앞자리 수는 현재 길이, 뒷자리 수는 맨 앞자리의 수를 나타냄
		int[][] dp = new int[N + 1][10];
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
			dp[0][i] = 1;
		}

		for (int n = 2; n <= N; n++) {
			for (int i = 1; i <= 9; i++) {
				if (i == 1) {
					dp[n][1] = (dp[n - 2][1] + dp[n - 1][2]) % REM;
				} else if (i == 9) {
					dp[n][9] = dp[n - 1][8];
				} else {
					dp[n][i] = (dp[n - 1][i - 1] + dp[n - 1][i + 1]) % REM;
				}
			}
		}

		// output
		int output = 0;
		for (int i = 1; i <= 9; i++) {
			output = (output + dp[N][i]) % REM;
		}
		System.out.println(output);
	}

}
