package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int A = 1;
		int B = 1;
		
		while(true) {
			
			int num[] = new int[31];
			
			num[1] = A;
			num[2] = B;
			for(int i = 3; i<=D; i++) {
				num[i] = num[i-1]+num[i-2];
			}
			if(num[D]==K) {
				System.out.println(A);
				System.out.println(B);
				break;
			} else if(num[D]>K) {
				A = A+1;
				B = A;
			} else if(num[D]<K) {
				B = B+1;
			}
			
		}
	}
}
