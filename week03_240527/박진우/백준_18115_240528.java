package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj18115 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] card = new int[N];
		int[] origin = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		int index1 = 0;
		int index2 = 1;
		int index3 = N-1;
				
		StringBuilder sb = new StringBuilder();
		
		
		int cnt = N;
		for(int i = 0; i<N; i++) {
			if(card[i]==1) {
				origin[index1] = cnt;
				index1 = index2;
				index2++;
			} else if(card[i]==2) {
				origin[index2] = cnt;
				index2++;
			} else if(card[i]==3) {
				origin[index3] = cnt;
				index3--;
			}
			cnt--;
		}
		for(int i = 0; i<N; i++) {
			sb.append(origin[i]).append(" ");
		}
		
		System.out.print(sb);
	}
}
