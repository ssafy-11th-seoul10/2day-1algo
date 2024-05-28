package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2573 {
	static int cnt, N, M, time;
	static int map[][];
	static int melt[][];
	static boolean[][] visit;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N][M];
		map = new int[N][M];
		time=  0;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int z = 1;
		while(z < 2) {
			visit = new boolean[N][M];
			z=0;
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(!visit[i][j] && map[i][j]!=0) {
						isolate(i, j);
						z++;
					}
				}
			}
			
			if(z==0) {
				System.out.println(0);
				return;
			} else if(z>=2) {
				System.out.println(time);
				return;
			}
			
			//melt
			melt = new int[N][M];
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(map[i][j]>0)
						melting(i, j);
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					map[i][j] = map[i][j] + melt[i][j];
					if(map[i][j]<0) {
						map[i][j] = 0;
					}
				}
			}
			
			time++;
		}

	}
	
	static void melting(int x, int y) {
		for(int i = 0; i<4; i++) {
			if(x+dx[i]>= 0 && x+dx[i]<N && y+dy[i]>=0 && y+dy[i]<M) {
				if(map[x+dx[i]][y+dy[i]]==0) {
					melt[x][y]--;
				}
			}
		}
	}
	
	static void isolate(int x, int y) {
		if(visit[x][y]) {
			return;
		}
		visit[x][y] = true;
		for(int i = 0; i<4; i++) {
			if(x+dx[i]>=0 && x+dx[i]<N && y+dy[i]>=0 && y+dy[i]<M && !visit[x+dx[i]][y+dy[i]] && map[x+dx[i]][y+dy[i]]!=0) {
				isolate(x+dx[i], y+dy[i]);
			}
		}
	}
	
}
