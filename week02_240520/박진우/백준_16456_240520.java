package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj16456 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[50001];
		
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		for(int i = 4; i<50001; i++) {
			arr[i] = arr[i-1] + arr[i-3];
			arr[i] = arr[i]%1000000009;
		}
		
		System.out.println(arr[N-1]);
	}
	
}
