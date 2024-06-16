package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2508 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			br.readLine();
			int cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c=  Integer.parseInt(st.nextToken());
			
			char[][] map = new char[r][c];
			for(int j = 0; j<r; j++) {
				String s = br.readLine();
				for(int k = 0; k<c; k++) {
					map[j][k] = s.charAt(k);
				}
			}
			for(int j = 0; j<r; j++) {
				for(int k = 0; k<c; k++) {
					if(map[j][k]=='o') {
						if(j>0 && j<r-1) {
							if(map[j-1][k]=='v' && map[j+1][k]=='^')
								cnt++;
						}
						if(k>0 && k<c-1) {
							if(map[j][k-1]=='>' && map[j][k+1]=='<')
								cnt++;
						}
					}
						
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}
