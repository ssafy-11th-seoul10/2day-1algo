package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj2667 {
	
	static int N;
	static int k;
	static int count;
	static int map[][];
	static boolean visited[][];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> AL = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		k = 0;
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j= 0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visited[i][j] && map[i][j]!=0) {
					count = 0;
					dfs(i, j);
					k++;
					AL.add(count);
				}
			}
		}
		System.out.println(k);
		int [] arr = new int[k];
		for(int i = 0; i<k; i++) {
			arr[i] = AL.get(i);
		}
		Arrays.sort(arr);
		for(int i = 0; i<k; i++) {
			System.out.println(arr[i]);
		}
	
	}
	
	static void dfs(int x, int y) {
		
		visited[x][y] = true;
		count++;
		for(int i = 0; i<4; i++) {
			if(x+dx[i]>=0&&x+dx[i]<N && y+dy[i]>=0 && y+dy[i]<N && !visited[x+dx[i]][y+dy[i]] && map[x+dx[i]][y+dy[i]]>0) {
				dfs(x+dx[i], y+dy[i]);
			}
		}
	}
}
