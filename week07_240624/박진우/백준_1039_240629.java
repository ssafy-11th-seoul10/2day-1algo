package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1039 {
	
	static int[] visited = new int[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		Queue<Integer> q = new LinkedList<>();
		
		int len = 0;
		
		while(N/(int) Math.pow(10,  len) !=0) {
			len++;
		}
		q.add(N);
		
		while(!q.isEmpty() && K>0) {
			int size = q.size();
			
			for(int i = 0; i<size; i++) {
				int now = q.poll();
				
				for(int j = 0; j<len-1; j++) {
					for(int k = j+1; k<len; k++) {
						
						char[] c = String.valueOf(now).toCharArray();
						int next;
						
						char t = c[j];
						c[j] = c[k];
						c[k] = t;
						if(c[0] =='0')
							next = 0;
						else
							next = Integer.parseInt(new String(c));
						
						if(next!=0 && visited[next]!=K) {
							q.add(next);
							visited[next] = K;
						}
					}
				}
			}
			K--;
		}
		if(q.isEmpty()) {
			System.out.println(-1);
		} else {
			int ans = 0;
			
			for(int a : q) {
				if(ans<a) {
					ans = a;
				}
			}
			System.out.println(ans);
		}
		
	}
}
