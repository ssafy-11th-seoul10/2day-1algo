package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14500 {
	static int N, M, K;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = 0;
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		int q = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(j<M-1 && i < N-1) {
					q = map[i][j] + map[i+1][j+1] + map[i][j+1] + map[i+1][j];
					if(q>K)
						K=q;
				}
				if(j<M-3) {
					q = map[i][j] + map[i][j+1] +map[i][j+2] + map[i][j+3];
					if(q>K)
						K=q;
				}
				if(i<N-3) {
					q = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
					if(q>K)
						K=q;
				}
				if(i<N-2 && j<M-1) {
					q = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
					if(q>K)
						K=q;
					q = map[i][j] + map[i+1][j] + map[i+2][j] + map[i][j+1];
					if(q>K)
						K=q;
					q = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
					if(q>K)
						K=q;
					q = map[i][j] + map[i+1][j] + map[i+2][j+1] + map[i+1][j+1];
					if(q>K)
						K=q;
					q = map[i][j+1] + map[i+1][j] + map[i+2][j+1] + map[i+1][j+1];
					if(q>K)
						K=q;
					q = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
					if(q>K)
						K=q;
					q = map[i+2][j] + map[i+1][j+1] + map[i+2][j+1] + map[i][j+1];
					if(q>K)
						K=q;
					q = map[i+1][j] + map[i+1][j+1] + map[i+2][j] + map[i][j+1];
					if(q>K)
						K=q;
				}
				
				if(i<N-1 && j<M-2) {
					q = map[i][j] + map[i+1][j+1] + map[i][j+1] + map[i][j+2];
					if(q>K)
						K=q;
					q = map[i][j] + map[i+1][j] + map[i][j+1] + map[i][j+2];
					if(q>K)
						K=q;
					q = map[i][j] + map[i+1][j+1] + map[i+1][j] + map[i+1][j+2];
					if(q>K)
						K=q;
					q = map[i][j] + map[i+1][j+1] + map[i][j+1] + map[i+1][j+2];
					if(q>K)
						K=q;
					q = map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i+1][j+2];
					if(q>K)
						K=q;
					q = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
					if(q>K)
						K=q;
					q = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+2];
					if(q>K)
						K=q;
					q = map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i][j+2];
					if(q>K)
						K=q;
				}
			}
		}
		System.out.println(K);
		
	}
}
