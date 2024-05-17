package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long arr[] = new long[N+2];
		arr[1]=3;
		arr[2]= 7;
		for(int i = 3; i<=N+1; i++) {
			arr[i] = (2*arr[i-1] + arr[i-2])%9901;
		}
		System.out.println(arr[N]);
	}
}
