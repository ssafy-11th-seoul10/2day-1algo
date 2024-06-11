import java.io.*;
import java.util.*;



class Main {
	static int N;
	static int[][] pos_arr, bs_arr;
	static int[][] dir = new int[][] {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	
	static int black_max = 0; // first area
	static int white_max = 0; // second area
	
	
	
	public static boolean check(int x, int y) {
//		System.out.println(x + " " + y);
		if (pos_arr[x][y] == 0) return false;
		for (int i = 0; i < 4; i++) {
			int nx = x; int ny = y;
			while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (bs_arr[nx][ny] == 1) return false;
				nx += dir[i][0];
				ny += dir[i][1];
			}
		}
		return true;
	}
	
	
	public static void dfs_black(int depth, int black_cnt) {
		if (depth >= N * N) {
			if (black_max < black_cnt) {
				black_max = black_cnt;
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++) {
//						System.out.print(bs_arr[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			return;
		}
		int x = depth / N;
		int y = depth % N;
		
		int surplus = 1;
		while((((depth + surplus) / N) + ((depth + surplus) % N)) % 2 == 1) {
			surplus++;
		}
		
		if (check(x, y)) {
			bs_arr[x][y] = 1;
			dfs_black(depth + surplus, black_cnt+1);
			bs_arr[x][y] = 0;
		}
		dfs_black(depth + surplus, black_cnt);
		
		return;
	}
	
	public static void dfs_white(int depth, int white_cnt) {
		if (depth >= N * N) {
			if (white_max < white_cnt) {
				white_max = white_cnt;
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++) {
//						System.out.print(bs_arr[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			return;
		}
		int x = depth / N;
		int y = depth % N;
		
		int surplus = 1;
		while((((depth + surplus) / N) + ((depth + surplus) % N)) % 2 == 0) {
			surplus++;
		}
		
		if(check(x, y)) {
			bs_arr[x][y] = 1;
			dfs_white(depth + surplus, white_cnt+1);
			bs_arr[x][y] = 0;
		}

		dfs_white(depth + surplus, white_cnt);
		
		return;
	}
	
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(br.readLine());
		pos_arr = new int[N][N];
		bs_arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pos_arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs_black(0, 0);
		dfs_white(1, 0);
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(black_max + white_max);
//		System.out.println(white_max);
	}
}