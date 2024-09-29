package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj27964 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] X = new String[N];
		HashSet<String> hs = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			X[i] = st.nextToken();
			if(X[i].length()<6)
				continue;
			String cheese = X[i].substring(X[i].length()-6);
			if(cheese.equals("Cheese")) {
				hs.add(X[i]);
			}
		}
		if(hs.size()>=4)
			System.out.println("yummy");
		else
			System.out.println("sad");
	}
}
