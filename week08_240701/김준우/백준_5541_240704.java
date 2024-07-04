import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	public static boolean inGrid(int x, int y) {
		if (x <= 0 || y <= 0) return false;
		if (x > N || y > N) return false;
		if (x < y) return false;
		return true;
	}
	public static boolean inGrid2(int x, int y) {
		if (x >= 0 && x < N+1 && y >= 0 && y < N+1) return true;
		return false;
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			arr[x][y]++;
			if (inGrid2(x, y+1)) {arr[x][y+1]--;}
			if (inGrid2(x+l+1, y)) {arr[x+l+1][y]--;}
			if (inGrid2(x+l+2, y+1)) {arr[x+l+2][y+1]++;}
			if (inGrid2(x+l+1, y+l+2)) {arr[x+l+1][y+l+2]++;}
			if (inGrid2(x+l+2, y+l+2)) {arr[x+l+2][y+l+2]--;}
		}
		
		for(int i = 1; i <= N; i++) {
			int now = 0;
			for(int j = 1; j <= N; j++) {
				now = now + arr[i][j];
				arr[i][j] = now;
			}
		}

		for(int j = 1; j <= N; j++) {
			int now = 0;
			for(int i = j; i <= N; i++) {
				now = now + arr[i][j];
				arr[i][j] = now;
			}
		}

		for(int i = 1; i <= N; i++) {
			int now = 0;
			for(int j = 0; j <= N; j++) {
				if (inGrid(i+j, 1+j)) {
					now = now + arr[i+j][1+j];
					arr[i+j][1+j] = now;
				}
			}
		}
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) { 
				if(i >= j && arr[i][j] > 0) { 
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}
}




