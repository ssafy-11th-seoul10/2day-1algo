package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj21771 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int Rg = Integer.parseInt(st.nextToken());
		int Cg = Integer.parseInt(st.nextToken());
		int Rp = Integer.parseInt(st.nextToken());
		int Cp = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		
		for(int i = 0; i<R; i++) {
			String s = br.readLine();
			for(int j = 0; j<C; j++) {
				if(s.charAt(j)=='P') {
					cnt++;
				}
			}
		}
		
		if(cnt == Rp * Cp) {
			System.out.println(0);
		} else
			System.out.println(1);
		
	}
}
