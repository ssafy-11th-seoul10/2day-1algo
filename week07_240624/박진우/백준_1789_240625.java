package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1789 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());

		long S2 = 0;
		int N = 0;
		long p = 1;
		while(true) {
			if(S2>S) {
				break;
			}
			S2 = S2 + p++;
			N++;
		}
		System.out.println(N-1);
	}
}
