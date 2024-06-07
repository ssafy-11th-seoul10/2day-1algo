import java.io.*;
import java.util.*;



class Main {
	static int N, M;
	static int[] red, blue, hole;
	static char[][] arr;
	static int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int min_val = 11;
	// down right up left
	
	public static void move(int d) {
		int nx = red[0] + dir[d][0];
		int ny = red[1] + dir[d][1];
		while (arr[nx][ny] == '.') {
			if (nx == blue[0] && ny == blue[1]) {
				break;
			} else if (nx == hole[0] && ny == hole[1]) {
				nx += dir[d][0];
				ny += dir[d][1];
				break;
			}
			nx += dir[d][0];
			ny += dir[d][1];
		}
		red = new int[] {nx - dir[d][0], ny - dir[d][1]};
		
		nx = blue[0] + dir[d][0];
		ny = blue[1] + dir[d][1];
		while (arr[nx][ny] == '.') {
			if (nx == red[0] && ny == red[1] && !(red[0] == hole[0] && red[1] == hole[1])) {
				break;
			} else if (nx == hole[0] && ny == hole[1]) {
				nx += dir[d][0];
				ny += dir[d][1];
				break;
			}
			nx += dir[d][0];
			ny += dir[d][1];
		}
		blue = new int[] {nx - dir[d][0], ny - dir[d][1]};
		
		if (red[0] == hole[0] && red[1] == hole[1]) return;
		nx = red[0] + dir[d][0];
		ny = red[1] + dir[d][1];
		while (arr[nx][ny] == '.') {
			if (nx == blue[0] && ny == blue[1]) {
				break;
			} else if (nx == hole[0] && ny == hole[1]) {
				nx += dir[d][0];
				ny += dir[d][1];
				break;
			}
			nx += dir[d][0];
			ny += dir[d][1];
		}
		red = new int[] {nx - dir[d][0], ny - dir[d][1]};
		return;
	}
	
	public static void dfs(int depth) {
		if (blue[0] == hole[0] && blue[1] == hole[1]) {
			return;
		} else if (red[0] == hole[0] && red[1] == hole[1]) {
			if (min_val > depth) {
				min_val = depth;
			}
			return;
		} 
		if (depth > 10) return;
		for (int i = 0; i < 4; i++) {
			int rx = red[0], ry = red[1];
			int bx = blue[0], by = blue[1];
			
			move(i);
			dfs(depth+1);
			red = new int[] {rx, ry};
			blue = new int[] {bx, by};
		}
	}
	

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // num of query
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'R') {
					red = new int[] {i, j};
					arr[i][j] = '.';
				} else if (arr[i][j] == 'B') {
					blue = new int[] {i, j}; 
					arr[i][j] = '.';
				} else if (arr[i][j] == 'O') {
					hole = new int[] {i, j}; 
					arr[i][j] = '.';
				}
			}
		}
		dfs(0);
		if(min_val < 11) {
			System.out.println(min_val);
		} else {
			System.out.println(-1);
		}
	}
}