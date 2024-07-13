package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1174 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<String> q= new LinkedList<>();
		
		if(N<=10) {
			System.out.println(N-1);
		} else {
			for(int i = 0; i<10; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(i);
				q.add(sb.toString());
			}
			int cnt = 10;
			while(true) {
				String s = q.poll();
				if(s.equals("9876543210")) {
					System.out.println(-1);
					break;
				}
				for(int i = 0; i<Integer.parseInt(s)%10; i++) {
					StringBuilder sb = new StringBuilder();
					sb.append(s).append(i);
					q.add(sb.toString());
					cnt++;
					if(cnt==N) {
						System.out.println(sb.toString());
						break;
					}
				}
				if(cnt==N)
					break;
			}
		}
	}
}
