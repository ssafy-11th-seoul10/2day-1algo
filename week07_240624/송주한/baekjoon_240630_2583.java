package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_240630_2583 {

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int count;
	static boolean square[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		square = new boolean[n][m];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int y=y1; y<y2; y++) { 
				for(int x=x1; x<x2; x++){ 
					square[y][x] = true;
				}
			}
		}
		
		ArrayList<Integer> areaCount = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!square[i][j]) {
					count = 0;
					dfs(i,j, n, m);
					areaCount.add(count);
				}
			}
		}
		
		Collections.sort(areaCount);
		
		sb.append(areaCount.size()).append('\n');
		for(int i : areaCount)  {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y, int n, int m) {
		square[x][y] = true;
		count ++;
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(0<=nx && nx<n && 0<=ny && ny < m) {
				if(!square[nx][ny]) {
					dfs(nx,ny, n, m);
				}
			}
		}
	}

	
}