package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10814 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[][] arr = new String[N][2];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String age = st.nextToken();
			String name = st.nextToken();
			
			arr[i][0] = age;
			arr[i][1] = name;
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		System.out.print(sb);
	}
}
