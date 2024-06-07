package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1769 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] c = s.toCharArray();
		int k = 0;
		int cnt = 0;
		boolean isTrue = false;
		boolean did = false;
		if(s.length()==1)
		{
		int z = Integer.parseInt(s);
			System.out.println(0);
			if(z%3==0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		else {
			while(k==0 || k>=10) {
				k = 0;
				for(int i = 0; i<s.length(); i++) {
					k = k+ c[i]-'0';
				}
				if(!did) {
					did = true;
					if(k%3==0) {
						isTrue = true;
					}
				}
				s = String.valueOf(k);
				c = s.toCharArray();
				cnt++;
			}
			
			System.out.println(cnt);
			if(isTrue) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
