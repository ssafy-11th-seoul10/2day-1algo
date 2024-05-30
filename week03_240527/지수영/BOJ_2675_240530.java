package ws0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			char[] chars = st.nextToken().toCharArray();
			for(char s: chars) {
				for (int i = 0; i < R; i++) {
					sb.append(Character.toString(s));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
