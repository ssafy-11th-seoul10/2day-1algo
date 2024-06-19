import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_240619 {
	
	static int M, N, K;
	static int[][] board;
	static List<int[]> lettus;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			board = new int[N][M];
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				board[r][c] = 1;
			}
			
			int count = 0;
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(board[r][c] > 0) {
						bfs(new int[] {r, c});
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
		
	}
	static public void bfs(int[] start) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(start);
		board[start[0]][start[1]] = 0;
		
		while(!queue.isEmpty()) {
			int[] curr =  queue.poll();
			for(int d = 0; d < 4; d++) {
				int nr = curr[0]+dr[d];
				int nc = curr[1]+dc[d];
				if(inBound(nr, nc) && board[nr][nc] > 0) {
					queue.add(new int[] {nr, nc});
					board[nr][nc] = 0;
				}
			}
		}
	}
	static public boolean inBound(int nr, int nc) {
		if( 0 <= nr && nr < N && 0 <= nc && nc < M) {
			return true;
		}else {
			return false;
		}
	}
}
