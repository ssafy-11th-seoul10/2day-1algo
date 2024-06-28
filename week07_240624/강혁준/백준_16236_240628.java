import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] drow = { 0, -1, 0, 1 };
	static int[] dcol = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[] sharkPoint = { -1, -1 };
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9)
					sharkPoint = new int[] { i, j };
			}
		}

		// process
		int sharkSize = 2;
		int sharkAte = 0;
		int time = 0;
		while (true) {
			// BFS로 가장 가까우면서 먹을 수 있는 물고기가 있는지 확인
			Queue<int[]> que = new ArrayDeque<>();
			que.add(new int[] { sharkPoint[0], sharkPoint[1], 0 });
			int[] find = null;

			boolean[][] isChecked = new boolean[N][N];
			isChecked[sharkPoint[0]][sharkPoint[1]] = true;

			PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
				if (e1[2] != e2[2])
					return e1[2] - e2[2];
				else if (e1[0] != e2[0])
					return e1[0] - e2[0];
				return e1[1] - e2[1];
			});
			int threshold = -1;
			while (!que.isEmpty()) {
				int[] current = que.poll();
				if (threshold != -1 && threshold <= current[2])
					break;

				for (int dir = 0; dir < 4; dir++) {
					int nRow = current[0] + drow[dir];
					int nCol = current[1] + dcol[dir];

					// 이동할 수 있는 조건
					if (isValid(nRow, nCol, map) && !isChecked[nRow][nCol] && map[nRow][nCol] <= sharkSize) {
						isChecked[nRow][nCol] = true;
						if (map[nRow][nCol] != 0 && map[nRow][nCol] < sharkSize) {
							// 먹을 수 있음
							threshold = current[2] + 1;
							pq.add(new int[] { nRow, nCol, current[2] + 1 });
						} else {
							que.add(new int[] { nRow, nCol, current[2] + 1 });
						}
					}
				}
			}

			// 없으면 종료
			if (threshold == -1)
				break;

			// 있으면 해당 칸으로 가서 물고기를 먹음
			map[sharkPoint[0]][sharkPoint[1]] = 0;
			sharkPoint = pq.poll();
			map[sharkPoint[0]][sharkPoint[1]] = 9;

			// sharkAte를 1 증가시킴
			sharkAte++;
			// 만약 sharkAte가 sharkSize와 같다면 sharkAte를 0으로 초기화하고 sharkSize 증가
			if (sharkAte == sharkSize) {
				sharkAte = 0;
				sharkSize++;
			}

			// 시간 증가
			time += sharkPoint[2];

		}

		// putput
		System.out.println(time);
	}

	public static boolean isValid(int row, int col, int[][] map) {
		return 0 <= row && row < map.length && 0 <= col && col < map[0].length;
	}

}
