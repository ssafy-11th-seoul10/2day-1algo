import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int[] dr = { 1, -1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] box = new int[H][R][C];

		Queue<int[]> que = new ArrayDeque<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < R; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < C; j2++) {
					box[i][j][j2] = Integer.parseInt(st.nextToken());
					if (box[i][j][j2] == 1)
						que.add(new int[] { i, j, j2, 0 });
				}
			}
		}

		// process
		int output = -1;
		while (!que.isEmpty()) {
			if (isAllRiped(box)) {
				output = que.peek()[3];
				break;
			}

			int queLength = que.size();
			for (int i = 0; i < queLength; i++) {
				int[] current = que.poll();
				for (int dir = 0; dir < 6; dir++) {
					int nH = current[0] + dh[dir];
					int nR = current[1] + dr[dir];
					int nC = current[2] + dc[dir];
					if (isValid(box, nH, nR, nC) && box[nH][nR][nC] == 0) {
						box[nH][nR][nC] = 1;
						que.add(new int[] { nH, nR, nC, current[3] + 1 });
					}
				}
			}
		}

		// output
		System.out.println(output);
	}

	public static boolean isAllRiped(int[][][] box) {
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				for (int j2 = 0; j2 < box[0][0].length; j2++) {
					if (box[i][j][j2] == 0)
						return false;
				}
			}
		}
		return true;
	}

	public static boolean isValid(int[][][] box, int h, int r, int c) {
		return 0 <= h && h < box.length && 0 <= r && r < box[0].length && 0 <= c && c < box[0][0].length;
	}

}
