package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1421 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int Tree[] = new int[N];
		int high = 0;
		for(int i = 0; i<N; i++) {
			Tree[i] = Integer.parseInt(br.readLine());
			if(high<Tree[i])
				high = Tree[i];
		}
		long fin = -999999;
		for(int i = 1; i<=high; i++) {
			long l=0;
			for(int j = 0; j<N; j++) {
				int cnt = 0;
				if(Tree[j]>=i) {
					if(Tree[j]%i==0) {
						cnt = Tree[j] / i -1;
					} else
						cnt = Tree[j] / i;
					
					int cost = W*i * (Tree[j] / i) - cnt * C;
					if(cost > 0)
						l = l + cost;
				}
			}
			if(fin<l) {
				fin = l;
			}
		}
		
		System.out.println(fin);  
		
	}
}
