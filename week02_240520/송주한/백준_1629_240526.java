package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1629 {
	static long c;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());

		long ans = answer(a,b);
		System.out.println(ans);
		
	}
	private static long answer(long a, long b) {
		if(b==1) {
			return a%c;
		}
		
		long temp = answer(a, b/2);
		
		if(b%2 ==1) {
			return ((temp*temp)%c)*(a%c)%c;
		}
		
		return (temp*temp)%c;
	}
}
