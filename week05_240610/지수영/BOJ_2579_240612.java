import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_2579_240612 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+1];
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = stairs[1];
		if(N>=2) {
			dp[2] = stairs[1]+stairs[2];
		}
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+stairs[i-1])+stairs[i];
		}
		System.out.println(dp[N]);
	}
	


}
