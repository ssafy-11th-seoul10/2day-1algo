package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2535 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int nationCnt = 0;
		
		b2535[] b = new b2535[N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nation = Integer.parseInt(st.nextToken());
			b2535 B = new b2535(nation,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			b[i] = B;
			if(nation>nationCnt) {
				nationCnt = nation;
			}
		}
		int[] nations = new int[nationCnt+1];
		int[] medal = new int[6];
		
		Arrays.sort(b);
		int index = 0;
		for(int i = 0; i<N; i++) {
			if(nations[b[i].nation]<2) {
				nations[b[i].nation]++;
				medal[index++] = b[i].nation;
				medal[index++] = b[i].number;
			}
			if(index >=6)
				break;
		}
		System.out.print(medal[0]);
		System.out.print(" ");
		System.out.println(medal[1]);
		System.out.print(medal[2]);
		System.out.print(" ");
		System.out.println(medal[3]);
		System.out.print(medal[4]);
		System.out.print(" ");
		System.out.print(medal[5]);
		
	}
	
}
class b2535 implements Comparable<b2535>{
	
	int nation;
	int number;
	int score;
	
	b2535(int nation, int number, int score) {
		this.nation = nation;
		this.number = number;
		this.score = score;
	}
	
	@Override
	public int compareTo(b2535 o) {
		return o.score - this.score;
	}
}
