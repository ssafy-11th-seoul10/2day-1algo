import java.io.*;
import java.util.*;



class Main {
	static int R, C;
	static char[][] arr;
	static int[][] dir = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	static int[] parent;
	static boolean[][] visited;
	static Queue<int[]> deq = new ArrayDeque<int[]>();
	static int sx = -1, sy, ex, ey;
	// up left right down
	
	public static int find(int a) {
		int cur = a;
		while (cur != parent[cur]) {
			cur = parent[cur];
		}
		return cur;
	}
	
	public static void union(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		if (pA == pB) {
			return;
		} else if (pA < pB) {
			parent[pB] = pA;
		} else {
			parent[pA] = pB;
		}
	}
	
	public static boolean in_grid(int x, int y) {
		return x < R && 0 <= x && y < C && 0 <= y;
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int[] ele = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = ele[0] + dir[i][0];
				int ny = ele[1] + dir[i][1];
				if (in_grid(nx, ny) && !visited[nx][ny] && arr[nx][ny] == '.') {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
				else if (in_grid(nx, ny) && !visited[nx][ny] && arr[nx][ny] == 'X') {
					visited[nx][ny] = true;
					deq.add(new int[] {nx, ny});
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken()); // num of query
		arr = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'L' && sx == -1) {
					arr[i][j] = '.';
					sx = i; sy = j;
				} else if (arr[i][j] == 'L') {
					arr[i][j] = '.';
					ex = i; ey = j;
				}
			}
		}
		parent = new int[R * C];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == '.') {
					for (int k = 0; k < 4; k++) {
						int nx = i + dir[k][0];
						int ny = j + dir[k][1];
						if (in_grid(nx, ny) && arr[nx][ny] == '.') {
							union(nx * C + ny, i * C + j);
						}
					}
				}
			}
		}
		
//		for (int i = 0; i < parent.length; i++) {
//			System.out.print(parent[i] + " ");
//		}System.out.println();
		
		
		
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && arr[i][j] == '.') {
					bfs(i, j);
				}
			}
		}
		
//		System.out.println("---------------------");
//		for (int[] de : deq) {
//			System.out.println(de[0] + " " + de[1]);
//		}
//		System.out.println("---------------------");
		
		// initial setup finished
		
		int cnt = 0;
//		System.out.println(sx +" " + sy + " " + ex + " " + ey);
//		System.out.println(parent[sx * C + sy] + " " + parent[ex * C + ey]);
		while (find(sx * C + sy) != find(ex * C + ey)) {
			Queue<int[]> deq_next = new ArrayDeque<int[]>();
			
			for (int[] de : deq) {
				for (int i = 0; i < 4; i++) {
					int nx = de[0] + dir[i][0];
					int ny = de[1] + dir[i][1];
					if (in_grid(nx, ny) && visited[nx][ny]) {
						union(nx * C + ny, de[0] * C + de[1]);
					}
				}
			}
			
			for (int[] de : deq) {
				for (int i = 0; i < 4; i++) {
					int nx = de[0] + dir[i][0];
					int ny = de[1] + dir[i][1];
					if (in_grid(nx, ny) && !visited[nx][ny]) {
						visited[nx][ny] = true;
						deq_next.add(new int[] {nx, ny});
					}
				}
			}
			
//			for (int i = 0; i < parent.length; i++) {
//				System.out.print(parent[i] + " ");
//			}System.out.println();
			cnt++;
			deq = deq_next;
		}
//		System.out.println(find(sx * C + sy) + " " + find(ex * C + ey));

		System.out.println(cnt);
	}
}