import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		int[] prices = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}

		// process
		int[] dp = new int[N + 1];
		for (int card = 1; card <= N; card++) {
			for (int num = 1; num <= N; num++) {
				if (card <= num) {
					dp[num] = Math.max(dp[num], dp[num - card] + prices[card]);
				}
			}
		}

		// output
		System.out.println(dp[N]);
	}

}
