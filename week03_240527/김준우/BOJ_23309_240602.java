import java.io.*;
import java.util.*;

import org.omg.CosNaming.NamingContextPackage.NotFoundReasonHelper;




class Main {
	static int N, M;
	static int[] next, prev;
	
	

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // num of query
		next = new int[500_001];
		prev = new int[500_001];
		st = new StringTokenizer(br.readLine());
		int bf = 0;
		int now = 0;
		for (int i = 0; i < N; i++) {
			now = Integer.parseInt(st.nextToken());
			next[bf] = now;
			prev[now] = bf;
			bf = now;
		}
		now = next[0];
		next[bf] = now;
		prev[now] = bf;
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String q = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			if (q.equals("BN")) {
				int num2 = Integer.parseInt(st.nextToken());
				sb.append(next[num]).append("\n");
				int next_num = next[num];
				next[num] = num2;
				next[num2] = next_num;
				prev[next_num] = num2;
				prev[num2] = num;
			} else if (q.equals("BP")) {
				int num2 = Integer.parseInt(st.nextToken());
				sb.append(prev[num]).append("\n");
				int prev_num = prev[num];
				prev[num] = num2;
				prev[num2] = prev_num;
				next[prev_num] = num2;
				next[num2] = num;
			} else if (q.equals("CN")) {
				sb.append(next[num]).append("\n");
				next[num] = next[next[num]];
				prev[next[num]] = num;
			} else {
				sb.append(prev[num]).append("\n");
				prev[num] = prev[prev[num]];
				next[prev[num]] = num; 
			}
		}
		System.out.println(sb);
	}
}