package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15664 {
	static int[] arr, pmtt;
	static int N, M;
	static boolean[] used;
	static ArrayList<String> AL;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		AL = new ArrayList<>();
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		arr = new int[N];
		pmtt = new int[M];
		used = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		
		permutation(0, 0);
		
		for(int i = 0; i<AL.size(); i++) {
			System.out.println(AL.get(i));
		}
	}
	
	static void permutation(int k, int p) {
		int check = 0;
		if(k == M) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<M; i++) {
				sb.append(pmtt[i]).append(" ");
			}
			if(!AL.contains(sb.toString()))
				AL.add(sb.toString());
			return;
		}
		for(int i = p; i<N; i++) {
			if(!used[i] && check!=arr[i]) {
				used[i] = true;
				check = arr[i];
				pmtt[k] = arr[i];
				permutation(k + 1, i+1);
				used[i] = false;
			}
		}
	}
}
