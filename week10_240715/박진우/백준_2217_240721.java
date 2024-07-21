package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		for(int i = 0; i<N; i++) {
			rope[i] = Integer.parseInt(br.readLine());	
		}
		Arrays.sort(rope);
		
		int high = 0;
		int cnt = N;
		for(int i = 0; i<N; i++) {
			if(high<cnt*rope[i]) {
				high = cnt*rope[i];
			}
			cnt--;
		}
		System.out.print(high);
	}
}
