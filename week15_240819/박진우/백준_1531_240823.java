package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int map[][] = new int[100][100];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.valueOf(st.nextToken())-1;
			int y1 = Integer.valueOf(st.nextToken())-1;
			int x2 = Integer.valueOf(st.nextToken())-1;
			int y2 = Integer.valueOf(st.nextToken())-1;
			for(int x = x1; x<=x2; x++) {
				for(int y = y1; y<=y2; y++) {
					map[x][y] = map[x][y]+1;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i<100; i++) {
			for(int j = 0 ; j<100; j++) {
				if(map[i][j]>M) {
					cnt = cnt + 1;
				}
			}
		}
		System.out.println(cnt);
	}
}
