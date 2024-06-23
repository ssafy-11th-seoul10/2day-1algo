package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baeakjoon_240622_9251 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String arr1 = in.readLine();
		String arr2 = in.readLine();
		
		int dp[][] = new int[arr1.length()+1][arr2.length()+1];
		
		for(int i=1; i<= arr1.length();i++) {
			char a = arr1.charAt(i-1);
			for(int j=1; j<= arr2.length();j++) {
				if(a == arr2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		System.out.println(dp[arr1.length()][arr2.length()]);
	}
}
