package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj23278 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		double D = 0;
		double div = N-L-H;
		
		Arrays.sort(num);
		
		for(int i = 0; i<L; i++)
			num[i] = 0;
		for(int i = 0; i<H; i++) 
			num[N-i-1] = 0;	
		for(int i = 0; i<N; i++)
			D = D + num[i];
		
		System.out.println(D/div);
		
		
	}
}
