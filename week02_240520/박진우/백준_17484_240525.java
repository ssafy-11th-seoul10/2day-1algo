package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17484 {
	
	static int[][] map;
	static int N, M, low;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		low = 999999;
		
		map = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		for(int i = 0; i<M; i++) {
			travel(0, i, 5, 0);
		}
		System.out.println(low);
		
	}
	
	static void travel(int x, int y, int e, int sum) {
		if(x>=N) {
			if(low>sum) {
				low = sum;
			}
			return;
		}
		if(e==-1) {
			travel(x+1, y, 0, sum+map[x][y]);
			if(y<M-1) {
				travel(x+1, y+1, 1, sum+map[x][y]);
			}
		} else if(e==0) {
			if(y<M-1) {
				travel(x+1, y+1, 1, sum+map[x][y]);
			}
			if(y>0) {
				travel(x+1, y-1, -1, sum+map[x][y]);
			}
		} else if(e==1) {
			if(y>0) {
				travel(x+1, y-1, -1, sum+map[x][y]);
			} 
			travel(x+1, y, 0, sum+map[x][y]);
		} else if(e==5) {
			travel(x+1, y, 0, sum+map[x][y]);
			if(y>0) {
				travel(x+1, y-1, -1, sum+map[x][y]);
			}
			if(y<M-1) {
				travel(x+1, y+1, 1, sum+map[x][y]);
			}
		}
	}
}