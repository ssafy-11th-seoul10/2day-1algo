package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1094 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		int index = 0;
		int pole[] = {64, 32, 16,8, 4, 2,1};
		while(N > 0) {
			if(N<pole[index]) {
				index++;
			} else {
				N = N-pole[index];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
