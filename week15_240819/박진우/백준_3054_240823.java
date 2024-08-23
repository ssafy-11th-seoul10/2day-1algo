package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		int cur = 1;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		StringBuilder sb5 = new StringBuilder();
		
		sb1.append(".");
		sb2.append(".");
		sb3.append("#");
		sb4.append(".");
		sb5.append(".");
		
		for(;cur<N+1; cur++) {
			if(cur%3!=0) {
				sb1.append(".#.");
				sb2.append("#.#");
				sb3.append("." + str.substring(cur-1, cur) + ".");
				sb4.append("#.#");
				sb5.append(".#.");
			} else if(cur%3==0) {
				sb1.append("..*..");
				sb2.append(".*.*.");
				sb3.append("*." + str.substring(cur-1, cur) + ".*");
				sb4.append(".*.*.");
				sb5.append("..*..");
			}
			if((cur+1)%3!=0 && (cur)%3!=0) {
				sb1.append(".");
				sb2.append(".");
				sb3.append("#");
				sb4.append(".");
				sb5.append(".");
			}
		}
		if((cur)%3==0) {
			sb1.append(".");
			sb2.append(".");
			sb3.append("#");
			sb4.append(".");
			sb5.append(".");
		}
		
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb3);
		System.out.println(sb4);
		System.out.println(sb5);
	}
}

