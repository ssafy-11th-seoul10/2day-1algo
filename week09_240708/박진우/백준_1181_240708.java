package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class boj1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		
		for(int i = 0; i<N; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		
		Set A = new HashSet();
		for(int i = 0; i<N; i++) {
			if(!A.contains(words[i])) {
				System.out.println(words[i]);
			}
			A.add(words[i]);
		}
		
	}

}
