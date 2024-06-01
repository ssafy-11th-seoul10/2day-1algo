import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 3];
		for (int i = 3; i < N + 3; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// process
		int[][] dp = new int[N + 3][2];
		for (int i = 3; i < N + 3; i++) {
			// 현재 값을 선택하지 않았을 때
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

			// 현재 값을 선택했을 때
			dp[i][1] = arr[i] + Math.max(dp[i - 1][0], arr[i - 1] + Math.max(dp[i - 3][0], dp[i - 3][1]));
		}

		// output
		System.out.println(Math.max(dp[N + 2][0], dp[N + 2][1]));
	}

}
