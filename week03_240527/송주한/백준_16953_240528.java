package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon16953 {

	static int cnt = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		ans(a,b,1);
		if(cnt == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(cnt);
		}
	}

	private static void ans(long a, long b,int c) {
		if(a*2>=b) {
			if(a==b) {
				cnt = Math.min(cnt, c);
				return;
			}else if(a*2==b) {
				cnt = Math.min(cnt, c+1);
				return;
			}else {
				return;
			}
		}
		
		
		if(a*10+1 <= b) {
			ans(a*10+1,b, c+1);
		}
		if(a*2<=b) {
			ans(a*2,b, c+1);
		}
		
	}

}
