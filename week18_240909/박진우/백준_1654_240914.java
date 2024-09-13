package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int K = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
	
		int[] num = new int[K];
		long min = 0;
		long max = 0;
		
		for(int i = 0; i<K; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if(max<num[i]) {
				max = num[i];
			}
		}
		
		long count = 0;
		
		long left = min;
		long right = max+1;
		long mid = 0;
		while(left < right) {
			mid=(left+right)/2;
			count = 0;
			for(int i = 0; i<K; i++) {
				count = count + num[i]/mid;
			}
			
			if(count>=N) {
				left = mid+1;
			} else {
				right = mid;
			}
			
		}
		
		System.out.println(left-1);
		
	}
}
