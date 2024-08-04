package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] num = new long[N];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			num[i] = Long.parseLong(br.readLine());
		}
		
		for(int i = 0; i<N; i++) {
			if(isPrime(num[i])) {
				sb.append("YES");
			} else 
				sb.append("NO");
			sb.append("\n");
		}
		
		System.out.print(sb);
	} 
	
	static boolean isPrime(long l) {
		for(int i = 2; i<=1000000; i++) {
			if(l%i==0) {
				return false;
			}
		}
		return true;
	}
}
