package ws0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] alphabet = new int[26];
		
		char[] chars = br.readLine().toCharArray();
		
		int maxCnt = 0;
		
		//A = 65 Z = 90 a = 97 z = 122
		for(char c:chars) {
//			System.out.println(c);
//			System.out.println(c-'A');
//			System.out.println(c-'a');
//			System.out.println();
			if(c-'A' > 25) {
				alphabet[c-'a']++;
				maxCnt = Math.max(maxCnt, alphabet[c-'a']);
			}else {
				alphabet[c-'A']++;
				maxCnt = Math.max(maxCnt, alphabet[c-'A']);
			}
		}
		int maxAlphaCnt = 0;
		int maxAlpha = 0;
		for(int i = 0; i < 26; i++) {
			if(alphabet[i] == maxCnt) {
				maxAlpha = i;
				maxAlphaCnt++;
			}
		}
		
		if(maxAlphaCnt>1) {
			System.out.println("?");
		}else {
			char c = (char)(maxAlpha+65);
			System.out.println(c);
		}
	}

}
