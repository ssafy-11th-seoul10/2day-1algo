package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.valueOf(st.nextToken());
		int B = Integer.valueOf(st.nextToken());
		int C = Integer.valueOf(st.nextToken());
		
		System.out.println(calc(A, B, C));
	}
	
	static long calc(int A, int B, int C) {
		if(B==0) {
			return 1;
		}
		long res = calc(A, B/2, C);
		if(B%2==0) {
			return res * res % C;
		} else {
			return (res * res % C) * A % C;
		}
	}
}
