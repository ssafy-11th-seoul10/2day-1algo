package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class boj15665 {
	static int N, M;
	static int[] num, pmtt;
	static StringBuilder sb;
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		pmtt = new int[M];
		num = new int[N];
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		pmtt(0);
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next()).append("\n");
		}
		System.out.print(sb);

	}
	
	static void pmtt(int len) {
		if(len==M) {
			StringBuilder s = new StringBuilder();
			for(int i = 0; i<M; i++) {
				s.append(pmtt[i]).append(" ");
			}
			set.add(s.toString());
			return;
		}
		for(int i = 0; i<N; i++) {
			pmtt[len] = num[i];
			pmtt(len+1);
		}
	}
}
