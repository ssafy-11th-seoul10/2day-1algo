package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13900 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[N];
		long  sum = 0;
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum = sum + num[i];
		}		
		long ans = 0;
		for(int i = 0; i<N; i++) {
			ans = (sum-num[i])*num[i] + ans;
		}
		System.out.println(ans/2);
	}
}
