package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int num[] = new int[N+1];
		int count = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1
		int left = 0;
		int right = 1;
		int sum = num[left];
		while(left<=N && right<=N && right>=left) {
			if(sum==M) {
				count++;
				sum = sum - num[left++];
			} else if(sum<M) {
				sum = sum+num[right++];
			} else if(sum>M) {
				sum = sum - num[left++];
			}
		}
		
		System.out.println(count);
		
	}
}
