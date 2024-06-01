package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		char[] c = S.toCharArray();
		int one = 0;
		int zero = 0;
		int status = 2;

		for(int i = 0; i<c.length; i++) {
			if(status!=c[i]) {
				if(c[i]=='0') {
					one++;
				}
				else {
					zero++;
				}
			}
			status = c[i];
		}
		System.out.print(Math.min(one, zero));
	}
}
