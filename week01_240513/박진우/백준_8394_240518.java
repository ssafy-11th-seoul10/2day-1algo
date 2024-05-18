package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj8394 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		arr[0] = 1;
		arr[1] = 2;
		for(int i = 2; i<N+1; i++) {
			arr[i] = arr[i-2]+arr[i-1];
			arr[i] = arr[i]%10;
		}
		System.out.println(arr[N-1]);
		
	}
}
