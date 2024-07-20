package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2170 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int length = 0;
		
		StringTokenizer st;
		
		b2170 b[] = new b2170[N];
		for(int i = 0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			b2170 B = new b2170(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			b[i] = B;
		}
		Arrays.sort(b);
		int start = b[0].start;
		int end = b[0].end;
		
		for(int i = 1; i<N; i++) {
			//System.out.println(b[i].start + ", "+b[i].end);
			if(b[i].start>end) {
				length = length + (end-start);
				start =b[i].start;
				end = b[i].end;
			} else if(b[i].end>end) {
				end = b[i].end;
			}
		}
		length = length + (end-start);
		System.out.println(length);
	}
}
class b2170 implements Comparable<b2170>{

	int start;
	int end;
	
	b2170(int start, int end){
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(b2170 o) {
		if(this.start==o.start)
			return o.end-this.end;
		return this.start-o.start;
	}
	
}