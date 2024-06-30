import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int[][] dp;

	static int[] drow = { 1, -1, 0, 0 };
	static int[] dcol = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// get input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		// output
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int row, int col) {
		if (row == N - 1 && col == M - 1)
			return 1;
		else if (dp[row][col] != -1)
			return dp[row][col];

		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int nRow = row + drow[i];
			int nCol = col + dcol[i];
			if (isValid(nRow, nCol) && map[row][col] > map[nRow][nCol]) {
				sum += dfs(nRow, nCol);
			}
		}
		dp[row][col] = sum;
		return sum;
	}

	public static boolean isValid(int row, int col) {
		return 0 <= row && row < N && 0 <= col && col < M;
	}
}
