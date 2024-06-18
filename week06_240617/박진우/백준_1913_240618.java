package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1913 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken());
		
		int x = 0;
		int y = 0;
		int dist = 1;
		int x1 = N/2;
		int y1 = N/2;
		int pos = 0;
		int  c= 1;
		while(!(pos==1&&dist>=N-1)) {
			map[x1][y1] = c;
			if(pos==0) {
				
				for(int j = 0; j<dist; j++) {
					if(x1==0) {
						break;
					}
					map[--x1][y1] = ++c;
					
				}
				pos = 1;
				
			}
			else if(pos == 1) {
				for(int j = 0; j<dist; j++) {
					map[x1][++y1] = ++c;
				}
				pos = 2;
				dist++;
			}
			else if(pos == 2) {
				for(int j = 0; j<dist; j++) {
					map[++x1][y1] = ++c;
				}
				pos = 3;
				
			}
			else if(pos == 3) {
				for(int j = 0; j<dist; j++) {
					map[x1][--y1] = ++c;
				}
				pos = 0;
				dist++;
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				sb.append(map[i][j]).append(" ");
				if(map[i][j]==f) {
					x = i+1;
					y = j+1;
				}
			}
			sb.append("\n");
		}
		sb.append(x).append(" ").append(y);
		System.out.print(sb);
	}
}
