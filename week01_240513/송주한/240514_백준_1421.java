package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1421 {

	static public long max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(arr, (a, b) -> b - a);
		cost(arr, n, c, w, arr[0]);
		System.out.println(max);
	}

	private static void cost(Integer[] arr, int n, int c, int w, int num) {

		if (num == 0) {
			return;
		}

		int cut = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (num > arr[i])
				continue;
			if (arr[i] % num == 0) {
				if (arr[i] / num - 1 == 0) {
					cut += arr[i] / num - 1;
					count += arr[i] / num;
				} else if (c * (arr[i] / num - 1) < num * w * (arr[i] / num)) {
					cut += arr[i] / num - 1;
					count += arr[i] / num;
				}
			} else {
				if (c*(arr[i] / num) < num*w*(arr[i] / num)) {
					cut += arr[i] / num;
					count += arr[i] / num;
				}
			}
		}
		long sum = (long)w * count * num - (long)cut * c;
		if (max < sum) {
			max = sum;
		}

		cost(arr, n, c, w, num - 1);

	}
}
