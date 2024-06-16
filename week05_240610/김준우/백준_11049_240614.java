import java.io.*;
import java.util.*;



class Main {
	static int N;
	static int[][] matrices, min_result;
	
	
	public static void calculate_matrix(int s, int e) {
		int min = Integer.MAX_VALUE;
		for (int i = s; i < e; i++) {
//			System.out.println(s + " " + e);
			int result = min_result[s][i] + min_result[i+1][e] + (matrices[s][0] * matrices[i][1] * matrices[e][1]);
			if (result < min) { 
				min = result;
			}
		}
		min_result[s][e] = min;
	}
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		matrices = new int[N][2];
		min_result = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			matrices[i][0] = Integer.parseInt(st.nextToken());
			matrices[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int gap = 1; gap < N; gap++) {
			for (int i = 0; i < N-gap; i++) {
				calculate_matrix(i, i+gap);
			}
		}
		System.out.println(min_result[0][N-1]);
		
	}
}