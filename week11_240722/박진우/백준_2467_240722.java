package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2467 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int liquid[] = new int[N];
		for(int i = 0; i<N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		int first = 0;
		int second = 0;
		
		int start = 0;
		int end = N-1;
		int diff = 2000000001;
		
		while(start<end) {
			int sum = Math.abs(liquid[start] + liquid[end]);
			if(sum<diff) {
				diff = sum;
				first = liquid[start];
				second = liquid[end];
			}
			if(liquid[start]+liquid[end]<0) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.print(first + " " + second);
	}
}
