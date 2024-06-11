package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1124 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[100001];
		int[] am = new int[100001];
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i<100001; i++) {
			if(!prime[i]) {
				for(int j = i*2; j<100001; j = j+i) {
					prime[j] = true;
					int K = j;
					while(K%i==0) {
						K = K/i;
						am[j]++;
					}
				}
			}
		}
		
		int cnt = 0;
		for(int i = A; i<=B; i++) {
			if(!prime[am[i]]) {
				cnt = cnt+1;
			}
		}
		System.out.println(cnt);
	}
}
