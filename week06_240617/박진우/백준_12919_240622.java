package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj12919 {
	static boolean isTrue =false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		word(S, T);
		
		System.out.println(isTrue ? 1 : 0);
	}
	
	static void word(String S, String T) {
		if(S.length()==T.length()) {
			if(S.equals(T)) {
				isTrue = true;
			}
			return;
		}
		if(T.substring(0,1).equals("B")) {
			String other = T.substring(1);
			StringBuilder sb = new StringBuilder(other);
			String A = sb.reverse().toString();
			word(S, A);
		}
		if(T.substring(T.length()-1, T.length()).equals("A")) {
			word(S, T.substring(0, T.length()-1));
		}
		return;
		
	}
}
