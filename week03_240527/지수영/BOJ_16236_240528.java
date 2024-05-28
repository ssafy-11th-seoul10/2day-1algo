package ws0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 {

	public static class Shark {
		int r;
		int c;
		int size;
		int left;

		public Shark(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.left = size;
		}
	}

	public static class Fish implements Comparable<Fish> {
		int r;
		int c;
		int dist;

		public Fish(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if (o.dist == this.dist) {
				if (o.r == this.r) {
					return this.c - o.c;
				} else {
					return this.r - o.r;
				}
			}
			return this.dist - o.dist;
		}

	}

	static int N;
	static int[][] board;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Shark baby;
	static int time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
				if (board[r][c] == 9) {
					baby = new Shark(r, c, 2);
					board[r][c] = 0;
				}
			}
		}

		time = 0;
		duduru();
		System.out.println(time);
	}

	public static PriorityQueue<Fish> bfs() {
		PriorityQueue<Fish> pq = new PriorityQueue<Fish>();
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] { baby.r, baby.c, 0 });
		visited[baby.r][baby.c] = true;
		
		
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if(0 < board[curr[0]][curr[1]] && board[curr[0]][curr[1]] < baby.size) {
				pq.offer(new Fish(curr[0], curr[1], curr[2]));
			}

			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];

				if (!inBound(nr, nc) || visited[nr][nc])
					continue;
				if (board[nr][nc] > baby.size)
					continue;

				queue.offer(new int[] { nr, nc, curr[2] + 1 });
				visited[nr][nc] = true;
			}
		}
		return pq;
	}
	
	

	public static void duduru() {
		
		while(true) {
			PriorityQueue<Fish> pq = bfs();
			
			if(pq.isEmpty()) {
				break;
			}
			Fish end = pq.poll();
			
			time += end.dist;
			
//			baby.left--;
			if(--baby.left == 0) {
				baby.size++;
				baby.left = baby.size;
			}
			
			board[end.r][end.c] = 0;
			
			baby.r = end.r;
			baby.c = end.c;
			
		}

	}

	public static boolean inBound(int nr, int nc) {
		if (0 <= nr && nr < N && 0 <= nc && nc < N)
			return true;
		else
			return false;
	}

}