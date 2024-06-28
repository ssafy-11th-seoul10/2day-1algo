package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2589 {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dx[] = {0, -1, 0, 1};
		int dy[] = {-1, 0, 1, 0};
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		int high = 0;
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j]=='L') {
					visited = new boolean[N][M];
					visited[i][j] = true;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i, j, 0});
					while(!q.isEmpty()) {
						int[] A = q.poll();
						int x = A[0];
						int y = A[1];
						int c = A[2];
						if(high<c) {
							high = c;
						}
						for(int k = 0; k<4; k++) {
							if(x+dx[k]>=0&&x+dx[k]<N && y+dy[k]>=0 && y+dy[k]<M && map[x+dx[k]][y+dy[k]]=='L'&&!visited[x+dx[k]][y+dy[k]]) {
								q.add(new int[] {x+dx[k], y+dy[k], c+1});
								visited[x+dx[k]][y+dy[k]]= true;
							}
						}
					}
				}
				
			}
		}
		System.out.println(high);
	}
}
