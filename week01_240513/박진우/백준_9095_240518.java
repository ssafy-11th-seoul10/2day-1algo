package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9095 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[12];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		for(int i = 3; i<12; i++) {
			arr[i] = arr[i-3] + arr[i-1] + arr[i-2];
		}
		for(int i = 0; i<N; i++) {
			System.out.println(arr[Integer.parseInt(br.readLine())-1]);
		}
	}
}
