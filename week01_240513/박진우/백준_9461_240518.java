package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9461 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[101];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		for(int i = 3; i<101; i++) {
			arr[i] = arr[i-3] + arr[i-2];
		}
		for(int i = 0; i<N; i++) {
			int K = Integer.parseInt(br.readLine());
			
			
			System.out.println(arr[K-1]);
		}
	}
}
