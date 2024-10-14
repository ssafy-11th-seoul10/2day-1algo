package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int A1 = A;
		int B1 = B;
		
		int gcd = 1, lcd = 1;
		if(A>B) {
			for(int i = 2; i<=A; i++) {
				if(A1%i==0 && B1%i==0) {
					A1 = A1/i;
					B1 = B1/i;
					gcd = gcd * i;
					i--;
				}
			}
		} else {
			for(int i = 2; i<=B; i++) {
				if(A1%i==0 && B1%i==0) {
					A1 = A1/i;
					B1 = B1/i;
					gcd = gcd * i;
					i--;
				}
			}
		}
		
		
		A1 = A;
		B1 = B;
		
		if(A>B) {
			for(int i = 2; i<=A; i++) {
				if(A1%i==0 && B1%i==0) {
					A1 = A1/i;
					B1 = B1/i;
					lcd = lcd * i;
					i--;
				}
			}
			lcd = lcd * A1 * B1;
		} else {
			for(int i = 2; i<=B; i++) {
				if(A1%i==0 && B1%i==0) {
					A1 = A1/i;
					B1 = B1/i;
					lcd = lcd * i;
					i--;
				}
			}
			lcd = lcd * A1 * B1;
		}
		System.out.println(gcd);
		System.out.println(lcd);
		
		
	}
}
