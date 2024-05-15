package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11651 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// get input
		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// process
		Arrays.sort(points, (p1, p2) -> {
			if (p1.y == p2.y)
				return p1.x - p2.x;
			else
				return p1.y - p2.y;
		});

		// output
		for (Point point : points) {
			sb.append(point.x).append(' ').append(point.y).append('\n');
		}
		System.out.println(sb);
	}

}
