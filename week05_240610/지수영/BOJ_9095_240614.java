import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_240614 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		// DP 문제
		int[] DP = new int[12];
		DP[0] = 0;
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 4;
		
		for (int i = 4; i < 12; i++) {
			DP[i] = DP[i-3] + DP[i-2] + DP[i-1];
		}
		
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(DP[N]).append("\n");
		}
		System.out.println(sb);
	}

}
