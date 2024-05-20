package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16953 {
	
	static long M;
	static int low;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		low = 999999;
		int N = Integer.valueOf(st.nextToken());
		M = Long.valueOf(st.nextToken());
	
		calc(N,1);
		
		if(low==999999)
			System.out.println(-1);
		else
			System.out.println(low);
	}
	
	static void calc(long i, int k) {
		if(i==M) {
			if(low>k) {
				low = k;
			}
		} else if(i>M) {
			return;
		}
		calc(i*10+1, k+1);
		calc(i*2, k+1);
		
	}
}
