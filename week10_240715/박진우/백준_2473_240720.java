package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2473 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long A[] = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(A);
		
		long low = 30000000001L;
		long first = 0;
		long second = 0;
		long third = 0;
		long val;
		
		for(int i = 0; i<N; i++) {
			int left = i+1;
			int right = N-1;
			
			while(left<right) {
				long x = A[i] + A[left] + A[right];
				
				val = Math.abs(x);
				
				if(val<low) {
					low = val;
					first = A[i];
					second = A[left];
					third = A[right];
				}
				
				if(x > 0)
					right--;
				else
					left++;
			}
		}
	StringBuilder sb = new StringBuilder();
	sb.append(first).append(" ").append(second).append(" ").append(third);
	System.out.println(sb);
	}
}
