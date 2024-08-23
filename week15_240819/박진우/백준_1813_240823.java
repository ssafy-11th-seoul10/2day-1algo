package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1813 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num[] = new int[51];
		
		for(int i = 0; i<N; i++) {
			int A = Integer.parseInt(st.nextToken());
			num[A] = num[A]+1;
		}
		for(int i = 50; i>=0; i--) {
			if(num[i]==i) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}

