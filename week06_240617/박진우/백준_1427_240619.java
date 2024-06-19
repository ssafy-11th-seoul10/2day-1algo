package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		char[] c = S.toCharArray();
		Arrays.sort(c);
		for(int i = 0; i<c.length; i++) {
			System.out.print(c[c.length-i-1]);
		}
	}
}
