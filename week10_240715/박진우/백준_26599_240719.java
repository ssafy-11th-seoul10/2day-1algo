package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj26599 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		b26599[] b = new b26599[N];
		for(int i = 0; i<N; i++) {
			b26599 A = new b26599(Integer.parseInt(st.nextToken()), i+1);
			b[i] = A;
		}
		Arrays.sort(b);
		StringBuilder sb = new StringBuilder();
		
		if(N>=4) {
			boolean isTrue = true;
			for(int i = 1; i<4; i++) {
				if(b[N-i].power - b[N-i-1].power>M) {
					isTrue = false;
				}
			}
			
			if(!isTrue) {
				System.out.println("NO");
				return;
			}
			sb.append(b[N-3].index).append(" ").append(b[N-4].index).append(" ");
			for(int i = 0; i<N-4; i++) {
				sb.append(b[i].index).append(" ");
			}
			sb.append(b[N-2].index).append(" ").append(b[N-1].index);
			System.out.println("YES");
			System.out.println(sb);
		}
		else {
			sb.append(b[0].index).append(" ");
			for(int i = 1; i<N; i++) {
				if(b[i].power-b[i-1].power>M) {
					System.out.println("NO");
					return;
				}
				else {
					sb.append(b[i].index).append(" ");
				}
			}
			System.out.println("YES");
			System.out.println(sb);
		}
	}
}
class b26599 implements Comparable<b26599>{

	int power;
	int index;
	
	b26599(int power, int index){
		this.power = power;
		this.index = index;
	}
	
	@Override
	public int compareTo(b26599 o) {
		return this.power - o.power;
	}
	
}