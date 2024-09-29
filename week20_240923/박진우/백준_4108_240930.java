package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj4108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		while(R!=0) {
			
			char[][] map = new char[R][C];
			for(int i = 0; i<R; i++) {
				String s = br.readLine();
				for(int j = 0; j<C; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C; j++) {
					if(map[i][j]=='*') {
						sb.append("*");
					} else {
						int k = 0;
						if(i-1>=0 && j-1>=0 && map[i-1][j-1]=='*')
							k++;
						if(i-1>=0 && map[i-1][j]=='*')
							k++;
						if(i-1>=0&&j+1<C&&map[i-1][j+1]=='*')
							k++;
						if(j-1>=0&&map[i][j-1]=='*')
							k++;
						if(j+1<C&&map[i][j+1]=='*')
							k++;
						if(i+1<R&&j-1>=0&&map[i+1][j-1]=='*')
							k++;
						if(i+1<R&&map[i+1][j]=='*')
							k++;	
						if(i+1<R&&j+1<C&&map[i+1][j+1]=='*')
							k++;
						sb.append(k);
					}
				}
				sb.append("\n");
			}
			
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
		}
		System.out.print(sb);
	}
}
