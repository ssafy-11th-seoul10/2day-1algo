package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_240616_15666 {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] arr;
	static int[] arrCopy;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int n = (int) str.charAt(0) - 48;
		int m = (int) str.charAt(2) - 48;
		arr = new int[m];
		arrCopy = new int[m];
		num = new int[n];
		visited = new boolean[n + 1];
		str = in.readLine();
		StringTokenizer st = new StringTokenizer(str);
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		permutation(0, n, m, 0);
		System.out.println(sb);
	}

	public static void permutation(int cnt, int n, int m, int start) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");

			return;
		}

		int check = -1;
		for (int i = start; i < n; i++) {
			if (check != num[i]) {
				check = num[i];
				arr[cnt] = num[i];
				permutation(cnt + 1, n, m, i);
			}
		}

		return;
	}
}

