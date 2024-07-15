package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon_240715_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[m + 1];

		check[0] = check[1] = true;
		for (int i = 2; i <= Math.sqrt(check.length); i++) {
			if (check[i])
				continue;
			for (int j = i * i; j < check.length; j += i) {
				check[j] = true;
			}
		}

		for (int i = n; i <= m; i++) {
			if (!check[i]) {
				System.out.println(i);
			}
		}
	}

}
