import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		int N = Integer.parseInt(br.readLine());

		// process
		long[] dp = new long[91];
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		// output
		System.out.println(dp[N]);
	}

}
