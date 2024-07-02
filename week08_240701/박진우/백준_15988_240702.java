package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15988{
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] arr = new long[1000001];
		arr[0]=0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i = 4; i<1000001; i++){
			arr[i] = arr[i-1]%1000000009 + arr[i-2]%1000000009+arr[i-3]%1000000009;
			arr[i] = arr[i]%1000000009;
		}
		for(int i = 0; i<N; i++){
			int v = Integer.parseInt(br.readLine());
			System.out.println(arr[v]);
		}
	}
}