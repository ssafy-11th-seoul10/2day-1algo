package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj5635 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		b5635 b[] = new b5635[N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			b5635 B = new b5635(null, i, i, i);			
			B.name = st.nextToken();
			B.day = Integer.valueOf(st.nextToken());
			B.month = Integer.valueOf(st.nextToken());
			B.year = Integer.valueOf(st.nextToken());
			b[i] = B;
		}
		Arrays.sort(b);
		System.out.println(b[N-1].name);
		System.out.println(b[0].name);
	}
}

class b5635 implements Comparable<b5635>{
	String name;
	int day;
	int month;
	int year;
	
	b5635(String name, int day, int month, int year){
		this.name = name;
		this.day =day;
		this.month = month;
		this.year = year;
	}
	
	@Override
	public int compareTo(b5635 o) {
		if(this.year!=o.year)
			return this.year-o.year;
		else if(this.month!=o.month)
			return this.month-o.month;
		return this.day-o.day;
	}
}