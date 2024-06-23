package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj4158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			
			if(A == 0 && B==0)
				break;
			
			Set<Integer> set = new HashSet<>();
			for(int i = 0; i<A; i++) {
				int N = Integer.parseInt(br.readLine());
				set.add(N);
			}
			int cnt = 0;
			for(int i = 0; i<B ; i++) {
				int N = Integer.parseInt(br.readLine());
				if(set.contains(N)) {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
}
